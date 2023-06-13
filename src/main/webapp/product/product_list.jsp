<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="../css/listmain.css">    

	<div class="container">
		<h3>상품 목록</h3>
		<table class="table table-bordered" >
			<thead>
				<tr>
					<th>상품명</th>
					<th>가격</th>
					<th>잔여재고량</th>
					<th>등록일</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items="${list }" varStatus="x">
				<tr>
					<td><a href="${vo.p_name}">${vo.p_name}</a></td>
					<td>${vo.price }</td>
					<td>${vo.stock }</td>
					<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd (E)"/> </td>
<%-- 					<td><a href="board_content.board?bno=${vo.bno }">${vo.title }</a></td> --%>
				</tr>
				</c:forEach>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="4" align="right">
						<form action="" class="form-inline" >
						  <div class="form-group">
						    <input type="text" name="search" placeholder="제목검색" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-default">
							<input type="button" value="상품등록" onclick="location.href='product_regist.pd'">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>

<%@ include file="../include/footer.jsp" %>
