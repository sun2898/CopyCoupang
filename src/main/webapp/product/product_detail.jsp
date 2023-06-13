<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
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
		
.responsive-table {
    width: 80%;
    max-width: 100%;
    overflow-x: auto;
  }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="font">

<div class="xx">
	<table border="1" class="responsive-table">
			<tr>
				<th rowspan="3"><img alt="이미지 경로 에러" src="${vo.path }" width="50" height="50"></th>
				<th width="300">${vo.p_name }<br>${vo.price }</th>
			</tr>
			<tr>
				<td><input type="radio" name="delivery">미사일배송하기<input type="radio" name="delivery">그냥배송하기</td>
			</tr>
			
			<tr>
				<td><input type="number" value="1"><input type="button" name="order" value="주문하기" onclick="location.href"></td>
			</tr>
			

	
	
	</table>
</div>



</body>
</html>