<%@page import="java.util.Enumeration"%>
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
	request.getParameter("name");
	request.getParameter("reading");
	request.getParameter("exercise");
	request.getParameter("movie");



	Enumeration enumer = request.getParameterNames();
	while(enumer.hasMoreElements()){
		String paramName = (String)enumer.nextElement();		
		String paramValue = request.getParameter(paramName);
		out.print(paramName+  ": " + paramValue +"<br>");
		
	}
	
%>
</body>
</html>





