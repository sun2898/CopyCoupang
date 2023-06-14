<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
<%@ include file = "../include/header.jsp" %>

<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	  @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
      
        .xx {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
	  
	  .font{
	  	font-family : 'Nanum Gothic', serif;
	  	color : black;
	  }
	</style>
</head>
<body>

<div align="center" class="container font">
	
	<div class="xx">
	
	<form action="regiFrom.review" method="post">
		<table border="1" width="600">
		
			<tr align="center" valign="middle">
				<td>상품 정보</td>
				<td><img src="../img/여우우.jpg" height="200" width="300" align="top"></td>
			</tr>
			
			<tr align="center" valign="middle">
				<td>별점을 선택해주세요.</td>
				<td>
					<input type="radio" name="star" value="1">1점
					<input type="radio" name="star" value="2">2점
					<input type="radio" name="star" value="3">3점
					<input type="radio" name="star" value="4">4점
					<input type="radio" name="star" value="5">5점
			</tr>
			
			<tr align="center" valign="middle">
				<td>리뷰 작성</td>
				<td><input type="text" name="content" size="50" placeholder="리뷰를 입력하세요." ></td>
			</tr>
			
			
		</table>
		<input type="submit" value="작성 완료">
		<input type="button" value="목록으로 돌아가기" onclick="location.href='review_list.review'">
	</form>
	
	</div>
	
</div>
</body>
<div align="center">
	<%@ include file="../include/footer.jsp"%>
</div>
</html>

