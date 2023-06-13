<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>    
	<section>
			<div align="center">
			
				<h3>회원정보 수정</h3>
				<b>${sessionScope.member_name} 님 회원 정보를 수정합니다</b>
				
					<form action="member_update.member" method ="post">
					 		<table border="1">
					 			<tr>
					 				<td>아이디</td>
					 				<td> <input type="text" name = "m_id" value = "${sessionScope.member_id }" readonly = "readonly" >
					 			<tr/>
					 			<tr>
					 				<td>비밀번호</td>
					 				<td> <input type="password" name = "m_pw"> </td>
					 			<tr/>
					 			<tr>
					 				<td>이름</td>
					 				<td> <input type="text" name = "m_name" value = "${vo.m_name }"> </td>
					 			<tr/>
					 			<tr>
					 				<td>이메일</td>
					 				<td> <input type="email" name = "m_email" value = "${vo.m_email} "> </td>
					 			<tr/>
					 			<tr>
					 				<td>주소</td>
					 				<td> <input type="text" name = "m_adress" value = "${vo.m_adress} "> </td>
					 			<tr/>
							</table>
					
							<input type="submit" value = "수정">
							<input type="button" value = "회원페이지로 가기" onclick = "location.href='member_mypage.member'">
				
			
					</form>	
			</div>
		
	</section>
<%@ include file = "../include/footer.jsp" %>