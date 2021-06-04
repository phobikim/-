<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="resultHobby1.jsp" method="post">
	<!-- <form action="resultHobby.jsp" method="post">-->
	
		<p>
			이름 : <input type="text" name="name">
		</p>
		<p>
		<input type="checkbox" name="reading">독서
		<input type="checkbox" name="exercise">운동
		<input type="checkbox" name="movie">영화
		</p>
		<input type="submit" value="전송">
	</form>
</body>
</html>



