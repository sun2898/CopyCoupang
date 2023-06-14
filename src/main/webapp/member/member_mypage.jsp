<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../include/header.jsp"%>
<body>
	<div id="wrapper">
		<section>
			<head>
				<title>마이페이지</title>
				<style type="text/css">
					table {
						margin-left: auto;
						margin-right: auto;
						border: 3px solid skyblue;
					}

					td {
						border: 1px solid skyblue;
					}

					#title {
						background-color: skyblue;
					}

					/* 스타일을 적용할 링크에 대한 클래스 지정 */
					.link-style {
						text-decoration: none;
						cursor: pointer;
						color: gray;
					}

					.link-style:hover {
						text-decoration: underline;
						color: blue;
					}
				</style>
				<div align="center">
					<br> <br>
					<b><font size="6" color="gray">마이페이지</font></b> <br>
					<br> <br>
					<h3 style="color: grey;">${sessionScope.member_name } (${sessionScope.member_id })님의 정보를 관리중입니다.</h3>
					
					<!-- 수정된 링크 -->
					<a href="member_modify.member" class="link-style">회원수정</a> 
					<a href="member_logout.member" class="link-style">로그아웃</a> 
					<a href="member_deleteForm.member" class="link-style">회원탈퇴</a>
				</div>
			</head>
		</section>
		<button type="button" id="top">상단이동</button>
	</div>
</body>
</html>
<div align="center">
	<%@ include file="../include/footer.jsp"%>
</div>
