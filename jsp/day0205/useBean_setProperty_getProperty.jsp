<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p" class="com.sist.dao.Person"/>
	<%
		//p.setName("이순신");
		//p.setId(20211004);
	%>
	<jsp:setProperty property="name" name="p" value="이순신"/>
	<jsp:setProperty property="id" name="p" value="20211004"/>
	
	아이디 : <%= p.getId() %><br>
	이름 : <%= p.getName() %><br>
	<hr>
	
	아이디 : <jsp:getProperty property="id" name="p"/><br>
	이름 : <jsp:getProperty property="name" name="p"/><br>
	
</body>
</html>






