<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.MemberDao"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

MemberDao dao = MemberDao.getInstance();
	ArrayList<MemberVO> list = dao.findAll();
	Gson gson = new Gson();
	String json_str  = gson.toJson(list);
%>
<%= json_str %>


