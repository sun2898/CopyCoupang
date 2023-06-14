package com.cucu.member.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cucu.member.model.MemberDAO;
import com.cucu.member.model.MemberVO;

public class MemberServiceImpl implements MemberService{

	//회원가입
	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		String m_email = request.getParameter("m_email");
		String m_adress = request.getParameter("m_adress");
		String m_type = request.getParameter("m_type");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.idCheck(m_id);
		
		if(result == 1) {
			return 1;
		}else {
			MemberVO vo = new MemberVO(m_id, m_pw, m_name, m_email, m_adress, null, m_type);
			dao.join(vo);
		}
		return 0;
	}

	//로그인
	@Override
	public MemberVO login(HttpServletRequest request, HttpServletResponse response) {
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.login(m_id, m_pw);
		
		return vo;
	}

	//회원정보 조회
	@Override
	public MemberVO getInfo(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String m_id = (String)session.getAttribute("member_id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.getInfo(m_id);
		return vo;
	}

	//회원정보 수정
	@Override
	public int updateInfo(HttpServletRequest request, HttpServletResponse response) {
		
		String m_id = request.getParameter("m_id");
		String m_pw = request.getParameter("m_pw");
		String m_name = request.getParameter("m_name");
		String m_email = request.getParameter("m_email");
		String m_adress = request.getParameter("m_adress");
		String m_type = request.getParameter("m_type");
		
		MemberVO vo = new MemberVO(m_id, m_pw, m_name, m_email, m_adress, null, m_type);
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.updateInfo(vo);
		
		return result;
		
	}

	@Override
	public int deleteInfo(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String m_id = (String)session.getAttribute("member_id");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.deleteInfo(m_id);
		
		return result;
		
	}

	

	
	

}
