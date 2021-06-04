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
	try{
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
	
	%>
	이름 : <%= name %><br>
	나이 : <%= age %><br>
	
	<%
	}catch(Exception e){
		out.println("예외발생:"+e.getMessage());
	}
	%>
	
	
</body>
</html>









