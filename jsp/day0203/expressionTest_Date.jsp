<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Date today = new Date();
	int year = today.getYear();
%>
연도 : <%=year+1900 %><br>
연도 : <%= today.getYear()+1900  %><br>
현재날짜와 시간 : <%= today %><br>
현재날짜와 시간 : <%= new Date() %>
</body>
</html>