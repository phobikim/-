<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.ScheduleVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.ScheduleDao"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	ScheduleDao dao = ScheduleDao.getInstance();
	ArrayList<ScheduleVo> list = dao.findAll();
	Gson gson = new Gson();
	String json_str = gson.toJson(list);
%>
<%= json_str %>