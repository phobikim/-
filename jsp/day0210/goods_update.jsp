<%@page import="com.sist.vo.GoodsVo"%>
<%@page import="com.sist.dao.GoodsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품수정</h2>
	
	<%
		int no= Integer.parseInt(request.getParameter("no"));
		GoodsDao dao = GoodsDao.getInstance();
		GoodsVo g= dao.findByNo(no);
	
	%>
	
	<form action="goods_updateOK.jsp" method="post" enctype="multipart/form-data">
	상품번호 : <input type="hidden" name="no" value="<%=g.getNo()%>"><br>
	상품이름 : <input type="text" name="name" value="<%=g.getName()%>"><br>
	상품수량 : <input type="text" name="qty" value="<%=g.getQty()%>"><br>
	상품가격 : <input type="text" name="price" value="<%=g.getPrice()%>"><br>
	<img src="upload/<%=g.getFname()%>" width="30" height="30"><br>
	<input type="hidden" name="fname" value="<%=g.getFname()%>">
	상품사진 : <input type="file" name="upload"><br>
	<input type="submit" value="수정">
	<input type="reset" value="취소">
</form>
</body>
</html>



