<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%!
	int count = 3;
	String makeItLower(String data){
		return data.toLowerCase();
	}
%>

<%
	int year = 2021;
	out.print("year:"+year+"<br>");
	out.print("count:"+count+"<br>");
	for(int i=1; i<=count ; i++){
		out.println(i+"<br>");
	}
	
%>

<%= count %><br>
<%= year %><br>
<%= makeItLower("HELLO KOERA") %>
</body>
</html>







