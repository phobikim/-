<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	
	String filename = "";
	//String realFoloer = "c:/upload";
	String realFolder = request.getRealPath("/resources/images");
	System.out.println(realFolder);
	int maxSize = 1024*1024*5;
	String encType= "utf-8";
	
	MultipartRequest multi = new MultipartRequest(request,
			realFolder, 
			maxSize,
			encType,
			new DefaultFileRenamePolicy());

	String productId = multi.getParameter("productId");
	String name = multi.getParameter("name");
	String unitPrice = multi.getParameter("unitPrice");
	String description = multi.getParameter("description");
	String manufacturer = multi.getParameter("manufacturer");
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String condition = multi.getParameter("condition");
	
	filename = multi.getFilesystemName("productImage");
	
	
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
	newProduct.setFilename(filename);
	
	
	ProductRepository dao = ProductRepository.getInstance();
	dao.addProduct(newProduct);
	response.sendRedirect("products.jsp");
	
	
	
%>
</body>
</html>









