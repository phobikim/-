<%@page import="com.sist.dao.ProductRepository"%>
<%@page import="com.sist.dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>

<!-- 
 <link rel="stylesheet" 
 href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 -->
<link rel="stylesheet" href="./resources/css/bootstrap.min.css"> 
 
</head>
<body>


<jsp:include page="menu.jsp"/>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3"> 상품목록 </h1>
	</div>
</div>

<%
	ProductRepository dao = ProductRepository.getInstance();
	ArrayList<Product> listOfProducts = dao.getAllProducts();		
%>

<main role="main">
	<div class="container">
		<div class="row" align="center">
			<%
				for(int i=0;i<listOfProducts.size();i++){
					Product product = listOfProducts.get(i);
					%>
					<div class="col-md-4">
						<img style="width:100%" src="./resources/images/<%=product.getFilename()%>">
						<h3><%=product.getPname() %></h3>
						<p><%=product.getDescription() %></p>
						<p><%=product.getUnitPrice() %></p>
						<p>
							<a class="btn btn-secondary" role="button" href="product.jsp?id=<%=product.getProductId() %>">상세정보</a>
						</p>
					</div>
					<%
				}
			%>
		</div>
	</div>
</main>

<jsp:include page="footer.jsp"/>
</body>
</html>















