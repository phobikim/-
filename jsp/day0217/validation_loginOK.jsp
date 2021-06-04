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
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	if(id.equals("tiger") && passwd.equals("1234")){
		out.println("올바른 회원입니다.");
	}else{
		out.println("올바른 회원이 아닙니다.");
	}
%>
</body>
</html>