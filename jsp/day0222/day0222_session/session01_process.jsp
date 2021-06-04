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
	
	<hr>
	
	


	<%
		String user_id = request.getParameter("id");
		String user_pwd = request.getParameter("passwd");
		
		if(user_id.equals("admin") && user_pwd.equals("1234")){
			session.setAttribute("userID", user_id);
			session.setAttribute("userPW", user_pwd);
			out.print("세션 설정이 성공했습니다.<br>");
			out.print(user_id+"님 환영합니다.");
		}else{
			out.print("세션 설정이 실패하였습니다.");
		}
	
	%>
	
	<hr>
	<a href="session02.jsp">세션변수 확인하러 가기</a><br>
	<a href="session03.jsp">세션변수 확인하러 가기2</a><br>
	<a href="session04.jsp">세션변수(userID) 삭제 후 확인하기</a><br>
	<a href="session06.jsp">세션 파기하기</a><br>
	<a href="session06_1.jsp">세션 파기후 새로운 세션 생성(새로운 연결하기)</a><br>
	<a href="session07.jsp">세션의 유효시간 설정 및 확인</a>
</body>
</html>






