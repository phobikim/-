<%@page import="com.sist.dao.ScheduleDao"%>
<%@page import="com.sist.vo.ScheduleVo"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String event_name = request.getParameter("event_name");
	String event_date = request.getParameter("event_date");
	ScheduleVo s = new ScheduleVo(0,event_name,event_date);
	ScheduleDao dao = ScheduleDao.getInstance();
	int re = dao.insert(s);
%>
{"msg":<%=re %>}