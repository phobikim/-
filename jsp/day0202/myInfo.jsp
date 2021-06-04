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
	String name = "김현규";
%>
<h1>이름 : <%= name %></h1><br>
<h2>나이 : <%= age %></h2><br>
</body>
</html>