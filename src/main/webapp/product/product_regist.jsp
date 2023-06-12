<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<div align="center" class="div_center">
	<h3>상품등록 페이지</h3>
	<hr>
	
	<form action="registProduct.pd" method="post">
		<table border="1" width="500">
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="p_name" style="width: 100%;">
				</td>
			</tr>
			<tr>
				<td>판매자</td>
				<td>
					<input type="text" name="seller" value="" readonly="readonly" size="10" style="width: 50%;">
				</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td>
					<input type="number" name="price">
				</td>
			</tr>
			<tr>
				<td>등록수량</td>
				<td>
					<input type="number" name="stock">
				</td>
			</tr>
			<tr>
				<td>상품 설명</td>
				<td>
					<textarea rows="10" style="width: 100%;" name="content"></textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
				<center>
					<input type="submit" value="완료">
					&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='product_list.pd'">         
				</center>
				</td>
			</tr>
			
		</table>
	</form>
	
</div>