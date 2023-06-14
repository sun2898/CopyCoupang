package com.cucu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cucu.cart.model.CartVO;
import com.cucu.cart.service.CartService;
import com.cucu.cart.service.CartServiceImpl;
import com.cucu.member.model.MemberVO;
import com.cucu.member.service.MemberService;
import com.cucu.member.service.MemberServiceImpl;
import com.cucu.product.model.ProductVO;
import com.cucu.product.service.ProductService;
import com.cucu.product.service.ProductServiceImpl;
import com.cucu.review.model.ReviewVO;
import com.cucu.review.service.ReviewService;
import com.cucu.review.service.ReviewServiceImplements;


@WebServlet("*.pd") //상품
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);

	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();

		String command = uri.substring( conPath.length() );

		System.out.println(command);
		
		CartService cservice = new CartServiceImpl();
		ProductService service = new ProductServiceImpl();
		ReviewService rservice = new ReviewServiceImplements();
		MemberService mservice = new MemberServiceImpl();
		
		//상품등록화면
		if(command.equals("/product/product_regist.pd")) {

			request.getRequestDispatcher("product_regist.jsp").forward(request, response);
		
		//상품등록기능
		}else if(command.equals("/product/registProduct.pd")) {
			
			service.insertProduct(request, response);

			response.sendRedirect("product_list.pd");
			
		//리스트출력
		} else if(command.equals("/product/product_list.pd")) {
      
			List<ProductVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("product_list.jsp").forward(request, response);


		} else if(command.equals("/product/product_detail.pd")) {
			List<ReviewVO> list = rservice.getReview(request, response);
			ProductVO vo = service.getProduct(request, response);
			request.setAttribute("vo", vo);
			request.setAttribute("list", list);

			request.getRequestDispatcher("product_detail.jsp").forward(request, response);
		}   else if(command.equals("/product/product_cart.pd")) {
			List<CartVO> list = cservice.getCart(request, response);
			request.setAttribute("list", list);


			request.getRequestDispatcher("product_cart.jsp").forward(request, response);
		} else if(command.equals("/product/product_addcart.pd")) {
			cservice.addCart(request, response);

			request.getRequestDispatcher("product_cart.pd").forward(request, response);

		} else if(command.equals("/product/product_order.pd")) {
			System.out.println("뭐냐고");	
			List<CartVO> list = cservice.getCart(request, response);
			MemberVO vo = mservice.getInfo(request, response);
			
			request.setAttribute("vo", vo);
			request.setAttribute("list", list);
			

			request.getRequestDispatcher("product_order.jsp").forward(request, response);

		//나의판매목록
		} else if(command.equals("/product/member_myselllist.pd")) {
			
			List<ProductVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("member_myselllist.jsp").forward(request, response);

		} else if(command.equals("/product/product_cart.pd")) {
			List<CartVO> list = cservice.getCart(request, response);
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("product_cart.jsp").forward(request, response);
			
		} else if(command.equals("/product/product_addcart.pd")) {
			cservice.addCart(request, response);
			List<CartVO> list = cservice.getCart(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("product_cart.jsp").forward(request, response);
			
		} else if(command.equals("/product/product_order.pd")) {
			
			request.getRequestDispatcher("product_order.jsp").forward(request, response);
			
		} else if(command.equals("/product/product_complete.pd")) {
			
			cservice.clearCart(request, response);
			response.sendRedirect(conPath +"/member/home.member");

		} else if(command.equals("/product/deleteProduct.pd")) {
			
			
			service.deleteProduct(request, response);
			
			response.setContentType("text/html; charset=utf-8;");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('안녕하세요');");
			out.println("</script>");
			
			response.sendRedirect("member_myselllist.pd");
			
			
		}

	}
}
