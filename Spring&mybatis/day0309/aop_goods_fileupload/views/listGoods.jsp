<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.goods{
		width: 200px;
		height: 200px;
		border: 1px solid pink;
		margin: 10px;
		display: inline;
		float: left;
		border-radius: 15px;
		padding: 10px;
	}
	
	#line{	
		clear:both;
		display: block;
	}
</style>
</head>
<body>
	<h2>상품목록</h2>
	
	<a href="insertGoods.do">상품등록</a>
	<hr>
	<div>
		<c:forEach var="g" items="${list }">
			<div class="goods">
				<img src="img/${g.fname }" width="100" height="100"/><br>
				상품명 : ${g.name }<br>
				가격 : ${g.price }<br>
			</div>
		</c:forEach>	
	</div>
	
	<div id="line"></div>
	
	<hr>
	
	<c:forEach var="i" begin="1" end="${totalPage }">
		<a href="listGoods.do?pageNUM=${i }">${i }</a>
	</c:forEach>
	
</body>
</html>






















