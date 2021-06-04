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
<jsp:include page="menu.jsp"/>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">배송 정보 </h1>
	</div>
</div>

<main role="main">
	<div class="container">
		<div class="text-center">
			<form action="./processShippingInfo.jsp" method="post" class="form-horizontal">
				<input type="hidden" name="cartId" value="<%=request.getParameter("cartId")%>">
				
				<div class="form-group row">
					<label class="col-sm-2">성명</label>
					<div class="col-sm-3">
						<input type="text" name="name" class="form-control">
					</div>
				</div>
				
				
				<div class="form-group row">
					<label class="col-sm-2">배송일</label>
					<div class="col-sm-3">
						<input type="text" name="shippingDate" class="form-control">(yyyy/mm/dd)
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2">국가명</label>
					<div class="col-sm-3">
						<input type="text" name="country" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2">우편번호</label>
					<div class="col-sm-3">
						<input type="text" name="zipCode" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2">주소</label>
					<div class="col-sm-3">
						<input type="text" name="addressName" class="form-control">
					</div>
				</div>
				
				<div class="form-group row">
					<div class="col-sm-offset-2 col-sm-10">
						<a href="./cart.jsp?cartId=<%=request.getParameter("cartId")%>" 
						class="btn btn-secondary" role="button">이전</a>
						<input type="submit" class="btn btn-primary" value="등록">
						<a href="./checkOutCancelled.jsp" class="btn btn-secondary" 
						role="button">취소</a>
					</div>
				</div>
				
				
			</form>
		</div>
	</div>
</main>

<%@ include file="footer.jsp" %>
</body>
</html>















