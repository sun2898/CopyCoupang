<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>

<section>

	<div align = "center">
		<h3>로그인</h3>
		
			<form action="" method = "post">
			
			<input type="text" name="id" placeholder = "아이디"><br>
			<input type="password" name="pw" placeholder = "비밀번호"><br>
			
			<input type="submit" value = "로그인">
			<input type="button" value = "가입하기" onclick = " location.href = '/JSPProject/member/member_join.jsp' ">
			
			</form>
			<div style="color: orange;" >${msg }</div>
	</div>

</section>

<%@ include file = "../include/footer.jsp" %>