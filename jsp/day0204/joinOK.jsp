<%@page import="com.sist.dao.MemberDao"%>
<%@page import="com.sist.vo.MemberVo"%>
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
	/*
	MemberVo m = new MemberVo();
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	m.setId(id);
	m.setPwd(pwd);
	m.setName(name);
	m.setEmail(email);*/
%>
<jsp:useBean id="m" class="com.sist.vo.MemberVo"/>
<jsp:setProperty property="*" name="m"/>
<%
	MemberDao dao = MemberDao.getInstance();
	int re = dao.insert(m);
%>
re : <%=re %>
</body>
</html>











