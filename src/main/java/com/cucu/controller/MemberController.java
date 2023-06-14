package com.cucu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cucu.member.model.MemberDAO;
import com.cucu.member.model.MemberVO;
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
		
		HttpSession session = request.getSession();
		
		if(command.equals("/member/home.member")) {
			
			response.sendRedirect("home.jsp");
//			request.getRequestDispatcher("home.jsp");
		
		}else if(command.equals("/product/mainpage.member")) {
			
			request.getRequestDispatcher("mainpage.jsp").forward(request, response);
		
		}else if(command.equals("/member/member_login.member")) {
			
			request.getRequestDispatcher("member_login.jsp").forward(request, response);
		
		
		}else if(command.equals("/member/member_join.member")) {
			
			request.getRequestDispatcher("member_join.jsp").forward(request, response);
		
		}else if(command.equals("/member/joinForm.member")) {
			
			int result = service.join(request, response);
			System.out.println(result);
			if(result == 1) {
				
				request.setAttribute("msg", "중복된 아이디 입니다");
				request.getRequestDispatcher("member_join.jsp").forward(request, response);
				
			}else{
				
				response.sendRedirect("member_login.jsp");
			}
		
		//로그인 기능
		}else if(command.equals("/member/loginForm.member")) {
			
			MemberVO vo = service.login(request, response);
			
			if(vo == null ) { //실패
				request.setAttribute("msg", "아이디/비밀번호를 확인하세요");
				request.getRequestDispatcher("member_login.jsp").forward(request, response);
				
			}else { //성공
				session.setAttribute("member_id", vo.getM_id());
				session.setAttribute("member_name", vo.getM_name());
				session.setAttribute("member_pw", vo.getM_pw());
				session.setAttribute("member_type", vo.getM_type());
				session.setAttribute("member_email", vo.getM_email());
				session.setAttribute("member_adress", vo.getM_adress());
				
				response.sendRedirect("member_mypage.member");
			}
			
		//마이페이지 화면
		}else if(command.equals("/member/member_mypage.member")) {
			request.getRequestDispatcher("member_mypage.jsp").forward(request, response);
		
		//로그아웃 
		}else if(command.equals("/member/member_logout.member")) {
			session.invalidate();
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		//회원정보조회 	
		}else if(command.equals("/member/member_modify.member")) {
			
			MemberVO vo = service.getInfo(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("member_modify.jsp").forward(request, response);
		
		//회원정보수정	
		}else if(command.equals("/member/member_update.member")) {
			
			int result = service.updateInfo(request, response);
			
			if(result == 1) { //수정 성공
				
				String m_name = request.getParameter("m_name");
				session.setAttribute("member_name", m_name);
				
				//out객체를 이용한 메시지 전달 //PrintWriter -> 출력함
				response.setContentType("text/html; charset=utf-8;");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정 성공했어요');");
				out.println("location.href='member_mypage.member';");
				out.println("</script>");
				
			}else { //수정 실패
				System.out.println(result);
				
				response.sendRedirect("member_modify.member");
			}
		//회원탈퇴 화면
		}else if(command.equals("/member/member_deleteForm.member")) {
			
			request.getRequestDispatcher("member_deleteForm.jsp").forward(request, response);
		
		//회원탈퇴 비밀번호 체크
		}else if(command.equals("/member/delete.member")) {
			
			String pw1 = (String)session.getAttribute("member_pw");
			String pw2 = request.getParameter("pwCheck");
			
			System.out.println(pw1);
			System.out.println(pw2);
			if(pw1.equals(pw2) ) { //비밀번호 같을 시
				
				int result = service.deleteInfo(request, response);
				System.out.println(result);
				response.setContentType("text/html; charset=utf-8;");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('그동안 감사했습니다!');");
				out.println("alert('정상적으로 탈퇴되었습니다!');");
				out.println("location.href='home.jsp';");
				out.println("</script>");
				session.invalidate();
			}else { //비밀번토 틀릴 시
				response.setContentType("text/html; charset=utf-8;");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호를 틀리셨습니다!');");
				out.println("location.href='member_deleteForm.member';");
				out.println("</script>");
				
			}
			
		//짭팡상품 화면!	
		}else if(command.equals("/product/product_list.member")) {
			
			request.getRequestDispatcher("product_list.jsp").forward(request, response);
		
		//상품리뷰 화면!	
		}else if(command.equals("/review/review_list.member")) {
			
			request.getRequestDispatcher("review_list.jsp").forward(request, response);
		} 
		
		
		
		
	}
}
