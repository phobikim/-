<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${title }</h2>
	<a href="insertGoods.do">상품등록</a>
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>번호</td>
			<td>상품명</td>
			<td>수량</td>
			<td>가격</td>
			<td>파일명</td>
		</tr>
		<c:forEach var="goods" items="${list }">
			<tr>
				<td>${goods.no }</td>
				<td>${goods.name }</td>
				<td>${goods.qty }</td>
				<td>${goods.price }</td>
				<td>${goods.fname }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>