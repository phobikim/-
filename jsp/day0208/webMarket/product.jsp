<%@page import="com.sist.dto.Product"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="menu.jsp"/>
<jsp:useBean id="productDAO" class="com.sist.dao.ProductRepository"/>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-3"> 상품 정보 </h1>
	</div>
</div>

<%
	String id = request.getParameter("id");
	Product product = productDAO.getProductById(id);
%>

<main role="main">
	<div class="container">
		<div class="col-md-6">
			<h3> <%= product.getPname() %> </h3>
			<p><%=product.getDescription() %> </p>
			<p><b>상품코드:</b><span class="badge badge-danger"><%=product.getProductId() %></span></p>
			<p><b>제조사:</b><%=product.getManufacturer() %></p>
			<p><b>분류:</b><%=product.getCategory() %></p>
			<p><b>재수 수:</b><%=product.getUnitInStock() %></p>
			<h4><%=product.getUnitPrice() %>원</h4>
			<p><a href="#" class="btn btn-info">상품주문</a>
				<a href="products.jsp" class="btn btn-secondary">상품 목록</a>
			</p>
		</div>
	</div>
</main>

<%@ include file="footer.jsp" %>
</body>
</html>















