<%@page import="com.sist.dao.BookDao"%>
<%@page import="com.sist.vo.BookVo"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	int no = Integer.parseInt( request.getParameter("no"));
	String name = request.getParameter("name");
	String publisher = request.getParameter("publisher");
	int price = Integer.parseInt(request.getParameter("price"));
	
	BookVo b = new BookVo(no,name,publisher,price);
	BookDao dao = BookDao.getInstance();
	int re = dao.insertBook(b);
	System.out.println("re:"+re);
	
%>
{"msg":<%=re%>}