package com.cucu.controller;

import java.io.IOException;

import javax.print.attribute.PrintRequestAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.member.service.MemberService;
import com.cucu.member.service.MemberServiceImpl;

@WebServlet("*.member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
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
		
		MemberService service = new MemberServiceImpl();
		
		if(command.equals("member_login.member")) {
			
			request.getRequestDispatcher("member_join.jsp");
		}
		
		
	}
}
