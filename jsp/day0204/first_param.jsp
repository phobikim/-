<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>이파일은 first_param.jsp입니다.</h3>
	<jsp:include page="second_param.jsp">
		<jsp:param value="SiSt" name="title"/>
		<jsp:param value="2021" name="year"/>
		<jsp:param value="<%= new Date() %>" name="date"/>
	</jsp:include>
	<p>Java Server Page</p>
</body>
</html>