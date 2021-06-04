<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="menu.jsp" %>

<div class="jumbotron">
	<div class="container">
		<h2 class="alert alert-danger">해당 상품이 존재하지 않습니다.</h2>
	</div>
</div>

<main role="main">
	<div class="container">
		<div class="text-center">
			<p> <%=request.getRequestURL() %>?<%=request.getQueryString() %>   </p>
			<p> <a href="products.jsp" class="btn btn-secondary">상품 목록</a> </p>
		</div>
	</div>
</main>

<%@ include file="footer.jsp" %>
</body>
</html>















