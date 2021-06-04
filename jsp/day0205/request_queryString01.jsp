<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String queryString = request.getQueryString();
	int no = Integer.parseInt(request.getParameter("no"));
	String title = request.getParameter("title");
%>
<%= queryString %><br>
no : <%= no %><br>
title : <%= title %><br>
</body>
</html>




