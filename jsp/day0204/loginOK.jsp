<%@page import="com.sist.dao.MemberDao"%>
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
	
	MemberDao dao = MemberDao.getInstance();
	if(dao.isMember(id, pwd)){
		session.setAttribute("member", "yes");
		response.sendRedirect("main.jsp");
	}else{
		response.sendRedirect("login.html");
	}
	
%>
</body>
</html>























