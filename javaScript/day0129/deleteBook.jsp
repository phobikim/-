<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BookDao dao = BookDao.getInstance();
	int re = dao.deleteBook(no);	
%>
{"msg":<%=re %>}