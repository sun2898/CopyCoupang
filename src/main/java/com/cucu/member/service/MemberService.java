package com.cucu.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cucu.member.model.MemberVO;

public interface MemberService {
	
	int join(HttpServletRequest request, HttpServletResponse response);
	MemberVO login(HttpServletRequest request, HttpServletResponse response);
	MemberVO getInfo(HttpServletRequest request, HttpServletResponse response);
	int updateInfo(HttpServletRequest request, HttpServletResponse response);
	int deleteInfo(HttpServletRequest request, HttpServletResponse response);

}
