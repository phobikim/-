<%@page import="java.util.ArrayList"%>
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
	ArrayList<String> list = new ArrayList<String>();
	list.add("������");
	list.add("������");
	list.add("������");
	list.add("������");
	list.add("������");
	list.add("������");
	out.print(list);
	
%>
<hr>
<%= list %>
</body>
</html>











