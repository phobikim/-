<%@page import="com.sist.dao.MemberDao"%>
<%@page import="com.sist.vo.MemberVO"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	
	MemberVO m = new MemberVO(id,name,pwd,email);
	//System.out.println("update.jsp������:"+ m);
	MemberDao dao = MemberDao.getInstance();
	int re = dao.updateMember(m);
%>
{"msg":<%=re %>}
