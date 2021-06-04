<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상품 등록</h2>
<hr>
<form action="insertGoods.do" method="post">
	상품번호 : <input type="text" name="no"><br>
	상품명 : <input type="text" name="name"><br>
	수량 : <input type="text" name="qty"><br>
	가격 : <input type="text" name="price"><br>
	파일명 : <input type="text" name="fname"><br> 
	<input type="submit" value="등록">
</form>
</body>
</html>