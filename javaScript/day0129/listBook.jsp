<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.BookVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	BookDao dao = BookDao.getInstance();
	ArrayList<BookVo> list = dao.selectAll();
	Gson gson = new Gson();
	String json_str = gson.toJson(list);
	
	//Thread.sleep(3000);
	
%>

<%= json_str %>