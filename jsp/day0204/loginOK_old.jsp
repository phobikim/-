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

	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");	
	String pwd = request.getParameter("pwd");
	
	if(id.equals("tiger") && pwd.equals("1234")){
		%>
		<jsp:forward page="main.jsp"/>
		<%
	}else{
		%>
		<jsp:forward page="login.html"/>
		<%
	}
%>
</body>
</html>









