<%@page import="com.sist.dao.ProductRepository"%>
<%@page import="com.sist.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String productId = request.getParameter("productId");
	String name = request.getParameter("name");
	String unitPrice = request.getParameter("unitPrice");
	String description = request.getParameter("description");
	String manufacturer = request.getParameter("manufacturer");
	String category = request.getParameter("category");
	String unitsInStock = request.getParameter("unitsInStock");
	String condition = request.getParameter("condition");
	
	int price;
	if(unitPrice.isEmpty()){
		price= 0;
	}else{
		price = Integer.parseInt(unitPrice);
	}
	
	int stock;
	if(unitsInStock.isEmpty()){
		stock = 0;
	}else{
		stock = Integer.parseInt(unitsInStock);
	}
	
	Product newProduct = new Product();
	newProduct.setProductId(productId);
	newProduct.setPname(name);
	newProduct.setUnitPrice(price);
	newProduct.setDescription(description);
	newProduct.setManufacturer(manufacturer);
	newProduct.setCategory(category);
	newProduct.setUnitInStock(stock);
	newProduct.setCondition(condition);
	
	ProductRepository dao = ProductRepository.getInstance();
	dao.addProduct(newProduct);
	response.sendRedirect("products.jsp");
	
	
	
%>
</body>
</html>









