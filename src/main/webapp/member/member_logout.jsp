<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>

	<section>
	
	<div align="center" >
	
	<h3 style="color: orange;" >감사합니다</h3>
		<h3 style="color: grey;">정상적으로 로그아웃 되었습니다</h3> <br>
		<a href="<%=request.getContextPath() %>/member/member_login.member">초기화면으로 돌아가기</a>
	</div>
	
	</section>
<%@ include file = "../include/footer.jsp" %>