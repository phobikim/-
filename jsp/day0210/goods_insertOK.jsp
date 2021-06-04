<%@page import="com.sist.dao.GoodsDao"%>
<%@page import="com.sist.vo.GoodsVo"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	//현재 어플리케이션의 upload폴더의 실제경로를 알아 옵니다.
	String path = request.getRealPath("upload");
	System.out.print(path);
	
	MultipartRequest multi = 
			new MultipartRequest(request,
					path, 
					1024*1024*5,
					"utf-8",
					new DefaultFileRenamePolicy());
	
	
	int no = Integer.parseInt(multi.getParameter("no"));
	String name = multi.getParameter("name");
	int qty = Integer.parseInt(multi.getParameter("qty"));
	int price = Integer.parseInt(multi.getParameter("price"));
	String fname = multi.getFilesystemName("fname");
	
	out.print("상품번호:"+no+"<br>");
	out.print("상품이름:"+name+"<br>");
	out.print("상품수량:"+qty+"<br>");
	out.print("상품가격:"+price+"<br>");
	out.print("상품사진:"+fname+"<br>");
	
	GoodsVo g = new GoodsVo();
	g.setNo(no);
	g.setName(name);
	g.setQty(qty);
	g.setPrice(price);
	g.setFname(fname);
	
	GoodsDao dao  = GoodsDao.getInstance();
	int re  = dao.insert(g);
	if(re == 1){
		response.sendRedirect("goods_list.jsp");
	}else{
		out.print("상품등록에 실패하였습니다.");
	}
%>
</body>
</html>






