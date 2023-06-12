package com.cucu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.product.model.ProductVO;
import com.cucu.product.service.ProductService;
import com.cucu.product.service.ProductServiceImpl;


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
		
		ProductService service = new ProductServiceImpl();
		
		if(command.equals("/product/product_regist.pd")) {
			
			request.getRequestDispatcher("product_regist.jsp").forward(request, response);
			
		} else if(command.equals("/product/registForm.pd")) {
			
			service.insertProduct(request, response);
			response.sendRedirect("product_list.pd");
		
			
		} else if(command.equals("/product/product_list.pd")) {
			
			List<ProductVO> list = service.getList(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
			
		}else if(command.equals("/product/product_detail.pd")) {
			request.getRequestDispatcher("product_detail.jsp").forward(request, response);
		}
	}
	
}
