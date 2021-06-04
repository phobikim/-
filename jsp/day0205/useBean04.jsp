<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="person" class="com.sist.dao.Person" scope="request"/>
<p>아이디:<%=person.getId() %></p>
<p>이름:<%=person.getName() %></p>
<%
	person.setId(20182005);
	person.setName("홍길동");
%>
<p>아이디:<%=person.getId() %></p>
<p>이름:<%=person.getName() %></p>
<hr>
<jsp:include page="useBean03.jsp"/>
</body>
</html>











