<%@page import="com.sist.vo.GoodsVo"%>
<%@page import="java.util.ArrayList"%>
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
<h2>상품목록</h2>
<hr>
<%
	 GoodsDao dao = GoodsDao.getInstance();
	 ArrayList<GoodsVo> list = dao.findAll();
%>
<a href="goods_insert.jsp">상품등록</a>
<table border="1" width="80%">
	<tr>
		<th>상품번호</th>
		<th>상품이름</th>
	</tr>
	<%
		for( GoodsVo g   :list){
			out.print("<tr>");
			out.print("<td>"+  g.getNo()   +"</td>");
			out.print("<td><a href='goods_detail.jsp?no="+g.getNo()+"'>"+  g.getName() +"</a></td>");
			out.print("</tr>");
		}
	%>
	
</table>
</body>
</html>














