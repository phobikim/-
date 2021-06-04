<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page errorPage="error.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
%>

<h2>사용자의 정보</h2>
이름 : <%= name %><br>
나이 : <%= age %>
</body>
</html>