<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/bg.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
    </style>
</head>
<body>

<div align="center" class="container">

	<form action="" method="post">
		<table border="1" width="500">
			<tr>
				<td>별점을 선택해주세요.</td>
				<td>
					<input type="radio" name="star" value="1">1점
					<input type="radio" name="star" value="2">2점
					<input type="radio" name="star" value="3">3점
					<input type="radio" name="star" value="4">4점
					<input type="radio" name="star" value="5">5점
			</tr>
			
			<tr>
				<td>리뷰 작성</td>
				<td><input type="text" name="content" size="50" placeholder="리뷰를 입력하세요." ></td>
			</tr>
			
			
		</table>
		<input type="submit" value="작성 완료">
		<input type="button" value="목록으로 돌아가기" onclick="location.href='review_list.review'">
	</form>
	
	
	
</div>
</body>
</html>