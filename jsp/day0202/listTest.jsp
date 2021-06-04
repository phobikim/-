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
	list.add("정소윤");
	list.add("서현익");
	list.add("김현규");
	list.add("신지영");
	list.add("최은혜");
	list.add("남혜진");
	out.print(list);
	
%>
<hr>
<%= list %>
</body>
</html>











