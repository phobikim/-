<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서수정</h2>
	<hr>
	
	<form action="updateBookOk.do" method="post">
		도서번호 : ${b.no }<br>
		<input type="hidden" name="no" value="${b.no }"><br>
		도서이름 : <input type="text" name="name" value="${b.name }"><br>
		출판사명 : <input type="text" name="publisher" value="${b.publisher }"><br>
		도서가격 : <input type="text" name="price" value="${b.price }"><br>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
</body>
</html>












