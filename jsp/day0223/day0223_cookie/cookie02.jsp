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
	Cookie []cookies = request.getCookies();
	
	if(cookies != null){

		out.println("현재 설정된 쿠키의 개수==>"+cookies.length+"<br>");
		out.println("=======================================<br>");
		for(int i=0; i<cookies.length; i++){
			out.println("쿠키이름:"+cookies[i].getName()+"<br>");
			out.println("쿠키값:"+cookies[i].getValue()+"<br>");
			out.println("-------------------------------<br>");
		}
	}
%>

<a href="cookie03.jsp">모든 쿠키 삭제하기</a>

</body>
</html>







