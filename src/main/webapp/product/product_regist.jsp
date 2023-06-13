<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview').src = "";
	}
}
</script> -->
<div align="center" class="div_center">
	<h3>상품등록 페이지</h3>
	<hr>
	
	<form action="registForm.pd" method="post">
		<table border="1" width="500">
			<tr>
				<td>상품명</td>
				<td>
					<input type="text" name="p_name" required="required" style="width: 100%;">
				</td>
			</tr>
			<tr>
				<td>판매자</td>
				<td>
					<input type="text" name="seller" required="required" size="10" style="width: 50%;">
				</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td>
					<input type="text" required="required" name="price">
				</td>
			</tr>
			<tr>
				<td>등록수량</td>
				<td>
					<input type="text" required="required" name="stock">
				</td>
			</tr>
			<tr>
				<td>상품 설명</td>
				<td>
					<textarea rows="10" style="width: 100%;" name="p_detail"></textarea>
				</td>
			
			</tr>
			<!-- <tr>
				<td>미리보기</td>
				<td>
					<input type="file" name="filepath" ><onchange="readURL(this);" ><br/>
					<img id="preview" />
				</td>
			</tr> -->
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