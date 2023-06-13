<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
.xx {
	display: flex;
	flex-direction : column;
	justify-content: center;
	align-items: center;
	height: 100vh;
        
    }
 .xx > .child {
 	width: 50%;
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
<title>${vo.p_name }</title>
</head>
<body class="font">


<div class="xx">
	<div class="child">
	<input type="button" onclick="location.href='product_list.pd'" value="리스트로가기">
	<table border="1" class="responsive-table" style="width: 100%;">
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
	
	<div class="child">
	<table border="1" style="width: 100%;">
		<thead align="center">
			<tr>
				<th>${li.m_id }</th>
				<th>${li.p_name }</th>
				<th>${li.review }</th>
				<th><fmt:formatDate value="${li.regdate }" pattern="yyyy-MM-dd"/></th>
				<th></th>
			
	</table>
	</div>
</div>


</body>
</html>