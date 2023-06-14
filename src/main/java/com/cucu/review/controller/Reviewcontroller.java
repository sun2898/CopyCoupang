package com.cucu.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.product.service.ProductService;
import com.cucu.product.service.ProductServiceImpl;
import com.cucu.review.service.ReviewService;
import com.cucu.review.service.ReviewServiceImplements;
@WebServlet("*.rv")
public class Reviewcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Reviewcontroller() {
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
		String command = uri.substring(conPath.length());

		System.out.println(command);
		
		ReviewService service = new ReviewServiceImplements();
		ProductService pservice = new ProductServiceImpl();

		if(command.equals("/review/review_register.rv")) {

			
			
			
			request.getRequestDispatcher("review_register.jsp").forward(request, response);
		}
	}

}
