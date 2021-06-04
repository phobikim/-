<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>상품목록</h2>
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
		</tr>
		
		<c:forEach var="g" items="${list }">
			<tr>
				<td>${g.no }</td>
				<td>${g.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>










