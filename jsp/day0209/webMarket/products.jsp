<%@page import="com.sist.dao.ProductRepository"%>
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


<jsp:include page="menu.jsp"/>
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3"> ��ǰ��� </h1>
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
						<h3><%=product.getPname() %></h3>
						<p><%=product.getDescription() %></p>
						<p><%=product.getUnitPrice() %></p>
						<p>
							<a class="btn btn-secondary" role="button" href="product.jsp?id=<%=product.getProductId() %>">������</a>
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















