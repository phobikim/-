<%@page import="java.util.Random"%>
<%@page import="java.util.TreeSet"%>

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
	TreeSet<Integer> set = new TreeSet<Integer>();
	Random r = new Random();
	
	while(set.size()<6){
		int n = r.nextInt(45)+1;
		set.add(n);
	}
%>
<h2>이번주 추천 로또번호</h2>
<h3><%=set %></h3>
</body>
</html>




