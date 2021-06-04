<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
죄송합니다. 서비스중에 다음과 같은 문제가 발생하였습니다. <hr>
exception.getMessage()  <%= exception.getMessage() %><br>
예외 : <%= exception %> <br>
toString : <%= exception.toString()  %><br>
getClass().getName()  : <%= exception.getClass().getName() %><br>
</body>
</html>