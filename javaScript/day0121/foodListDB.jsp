<%@page import="com.google.gson.Gson"%>
<%@page import="com.sist.vo.FoodVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.vo.FoodDao"%>
<%@ page language="java" contentType="application/json; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	FoodDao dao = FoodDao.getInstance();
	ArrayList<FoodVo> list = dao.selectAll();
	Gson gson = new Gson();
	String r = gson.toJson(list);
	/*
	String r = "[";
	for(FoodVo f : list){
		r += "\""+ f.getName() + "\",";
	}
	r = r.substring(0, r.length());
	r += "]";*/
%>
<%= r %>