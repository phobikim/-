<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dto.Product"%>
<%@page import="com.sist.dao.ProductRepository"%>
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
	String id = request.getParameter("id");
	System.out.println("id:"+id);
	if(id == null || id.trim().equals("")){
		response.sendRedirect("products.jsp");
		return;
	}
	
	ProductRepository dao = ProductRepository.getInstance();
	Product product = dao.getProductById(id);
	if(product == null){
		response.sendRedirect("exceptionNoProductId.jsp");
	}
	
	ArrayList<Product> goodsLIst = dao.getAllProducts();
	Product goods = new Product();
	for(int i=0; i<goodsLIst.size(); i++){
		goods = goodsLIst.get(i);
		if(goods.getProductId().equals(id)){
			break;
		}
	}
	


	ArrayList<Product> list =
			(ArrayList<Product>)session.getAttribute("cartlist");
	if(list == null){
		list = new ArrayList<Product>();
		session.setAttribute("cartlist", list);
	}
	
	int cnt = 0;
	Product goodsQnt = new Product();
	
	for(int i=0;i<list.size();i++){
		goodsQnt  = list.get(i);
		if(goodsQnt.getProductId().equals(id)){
			cnt++;
			int orderQuantity = goodsQnt.getQuantity()+1;
			goodsQnt.setQuantity(orderQuantity);
		}
	}
	
	if(cnt == 0){
		goods.setQuantity(1);
		list.add(goods);
	}
	
	response.sendRedirect("product.jsp?id="+id);
%>
</body>
</html>











