<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>도서 상세</h2>
	<hr>
	<p>도서번호 : ${b.no }</p>  
	<p>도서이름 : ${b.name }</p>  
	<p>출판사명 : ${b.publisher }</p>  
	<p>도서가격 : ${b.price }</p> 
	<hr> 
	<a href="listBook.do">목록</a>
	<a href="insertBook.do">등록</a>
	<a href="updateBook.do?no=${b.no }">수정</a>
	<a href="deleteBook.do?no=${b.no }">삭제</a>
</body>
</html>



