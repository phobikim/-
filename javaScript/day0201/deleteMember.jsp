<%@page import="com.sist.dao.MemberDao"%>
<%@ page language="java" contentType="applicatin/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	MemberDao dao = MemberDao.getInstance();
	int re = dao.deleteMember(id);
%>
{"msg":<%=re %>}

