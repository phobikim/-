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
���� : <%=year+1900 %><br>
���� : <%= today.getYear()+1900  %><br>
���糯¥�� �ð� : <%= today %><br>
���糯¥�� �ð� : <%= new Date() %>
</body>
</html>