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
	String user_id = (String)session.getAttribute("userID");
	String user_pw = (String)session.getAttribute("userPW");
	out.print("설정된 세션 userID:"+user_id+"<br>");
	out.print("설정된 세션 userPW:"+user_pw+"<br>");
	
	if(request.isRequestedSessionIdValid()){
		out.print("세션이 유효합니다.");
	}else{
		out.print("세션이 유효하지 않습니다.");
	}
	

	session.invalidate();
	
	out.println("<br>");
	
	
	if(request.isRequestedSessionIdValid()){
		out.print("세션이 유효합니다.");
	}else{
		out.print("세션이 유효하지 않습니다.");
	}
	
	/*
	user_id = (String)session.getAttribute("userID");
	user_pw = (String)session.getAttribute("userPW");
	out.print("설정된 세션 userID:"+user_id+"<br>");
	out.print("설정된 세션 userPW:"+user_pw+"<br>");*/

%>
</body>
</html>