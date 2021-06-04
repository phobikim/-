<%@page import="com.sist.dao.MemberDao"%>
<%@page import="com.sist.vo.MemberVo"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String sex  = request.getParameter("sex");
	String bloodType = request.getParameter("bloodType");
	
	String []hobbyArr = request.getParameterValues("hobby");
	
	String city = request.getParameter("city");
	String info = request.getParameter("info");	
%>
아이디 : <%=id %> <br>
암호 : <%=passwd %><br>
이름 : <%=name %><br>
전화 : <%=phone1 %>-<%=phone2 %>-<%=phone3 %><br>
성별 : <%= sex %><br>
혈액형 <%= bloodType %><br>
취미:
<%
	if(hobbyArr != null){
		for(int i=0; i<hobbyArr.length; i++){
			out.print(hobbyArr[i]+ " ");
		}
	}
%>
<br>
지역 : <%= city %><br>
자기소개 : <%= info %>
</body>
</html>












