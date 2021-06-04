<%@page import="com.sist.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDao dao = MemberDao.getInstance();
	String id = request.getParameter("id");
	int re = 0; 
	if(dao.isAlreadyId(id)){
		re = 1;
	}
%>
{"msg":<%=re %>}