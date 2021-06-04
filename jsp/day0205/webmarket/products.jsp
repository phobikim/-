<%@page import="com.sist.dto.Product"%>
<%@page import="java.util.ArrayList"%>
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
<jsp:useBean id="productDAO" class="com.sist.dao.ProductRepository" scope="session"/>


<jsp:include page="menu.jsp"/>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3"> 상품목록 </h1>
	</div>
</div>

<%
	ArrayList<Product> listOfProducts = productDAO.getAllProducts();		
%>

<main role="main">
	<div class="container">
		<div class="row" align="center">
			<%
				for(int i=0;i<listOfProducts.size();i++){
					Product product = listOfProducts.get(i);
					%>
					<div class="col-md-4">
						<h3><%=product.getPname() %></h3>
						<p><%=product.getDescription() %></p>
						<p><%=product.getUnitPrice() %></p>
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















