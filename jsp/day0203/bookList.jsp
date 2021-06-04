<%@page import="com.thoughtworks.xstream.XStream"%>
<%@page import="com.sist.vo.BookVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BookDao"%>
<%@ page language="java" contentType="application/xml; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	BookDao dao = BookDao.getInstance();
	ArrayList<BookVo> list = dao.selectAll();
	
	XStream x = new XStream();
	x.alias("book", BookVo.class);
	String r = x.toXML(list);
	
	
%>    
<%= r %>
    