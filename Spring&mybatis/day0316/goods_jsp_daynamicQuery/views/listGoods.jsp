<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품목록</h2>
	<hr>
	<form action="listGoods.do" method="post">
		상품명 : <input type="search" name="keyword">
		<input type="submit" value="검색">
	</form>
	
	<table border="1" width="80%">
		<thead>
			<tr>
				<th><a href="listGoods.do?orderFeild=no">상품번호</a></th>
				<th><a href="listGoods.do?orderFeild=name">상품이름</a></th>
				<th><a href="listGoods.do?orderFeild=qty">수량</a></th>
				<th><a href="listGoods.do?orderFeild=price">가격</a></th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="g" items="${list }">
				<tr>
					<td>${g.no }</td>
					<td>${g.name }</td>
					<td>${g.qty }</td>
					<td>${g.price }</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
</body>
</html>












