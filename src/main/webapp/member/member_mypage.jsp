<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp"%>
	<section>
	<div align = "center">
		<h3>회원정보 페이지</h3>
		
		${sessionScope.member_name }
		(${sessionScope.member_id })님의 정보를 관리중입니다. <br>
		
		<a href="member_modify.member">회원수정</a>
		
		<a href="member_logout.member">로그아웃</a>
		
		<a href="member_deleteForm.member">회원탈퇴</a>
	
	</div>

</section>
<%@ include file = "../include/footer.jsp"%>