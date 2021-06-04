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
<%
	int no = Integer.parseInt(request.getParameter("no"));
	GoodsDao dao = GoodsDao.getInstance();
	GoodsVo g= dao.findByNo(no);
	//out.print(g);
%>

<h2>상품상세보기</h2>
<hr>

상품번호 : <%= g.getNo() %><br>
상품이름 : <%= g.getName() %><br>
상품수량 : <%= g.getQty() %><br>
상품가격 : <%= g.getPrice() %><br>
<img  src="upload/<%=g.getFname()%>" width="200" height="200">
<hr>
<a href="goods_list.jsp">상품목록</a>
<a href="goods_insert.jsp">상품등록</a>
<a href="goods_update.jsp?no=<%=g.getNo()%>">상품수정</a>
<a href="goods_delete.jsp?no=<%=g.getNo()%>">상품삭제</a>
</body>
</html>









