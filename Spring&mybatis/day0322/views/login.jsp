<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
<form action="login.do" method="post">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
	아이디 : <input type="text" name="username"><br>
	암호 : <input type="password" name="password"><br>
	<input type="submit" value="로그인">
</form>
</body>
</html>






