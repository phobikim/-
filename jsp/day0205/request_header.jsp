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
	String hostValue = request.getHeader("host");
	String alValue =request.getHeader("accept-language");
%>
호스트명 : <%=hostValue %><br>
설정된언어 : <%= alValue %>
</body>
</html>