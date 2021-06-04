<%@page import="com.thoughtworks.xstream.XStream"%>
<%@page import="com.sist.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.MemberDao"%>
<%@ page language="java" contentType="application/xml; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	MemberDao dao = MemberDao.getInstance();
	ArrayList<MemberVO> list = dao.findAll();	
	XStream a = new XStream();
	a.alias("member", MemberVO.class);
	String r = a.toXML(list);
%>
<%= r %>
