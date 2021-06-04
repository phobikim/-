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
		String session_id = session.getId();
		out.print("세션 아이디 : "+ session_id+"<br>");
	%>

	<form action="session01_process.jsp" method="post">
		<p>아이디 : <input type="text" name="id"></p>
		<p>비밀번호 : <input type="password" name="passwd"></p>
		<p><input type="submit" value="전송"></p>
	</form>
</body>
</html>






