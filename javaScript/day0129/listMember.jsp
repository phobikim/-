<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	MemberDao dao = MemberDao.getInstance();
	ArrayList<MemberVo> list = dao.selectAll();
	Gson gson = new Gson();
	String r = gson.toJson(list);
	
	Thread.sleep(3000);
%>
<%= r %>