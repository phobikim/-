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
	int birthYear = 1994;
	int thisYear = (new Date()).getYear()+1900;
	int age = thisYear - birthYear +1 ;
	String name = "������";
%>
<h1>�̸� : <%= name %></h1><br>
<h2>���� : <%= age %></h2><br>
</body>
</html>