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
	<h2>${title }</h2>
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>������ȣ</td>
			<td>������</td>
		</tr>	
		
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.no }</td>
				<td>${b.name }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>









