<%@page import="java.io.File"%>
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
	String path = request.getRealPath("upload");
	MultipartRequest multi = new MultipartRequest(request,
			path,
			1024*1024*5,
			"utf-8",
			new DefaultFileRenamePolicy());
	
	int no = Integer.parseInt(multi.getParameter("no"));
	String name = multi.getParameter("name");
	int qty = Integer.parseInt(multi.getParameter("qty"));
	int price = Integer.parseInt( multi.getParameter("price"));
	String fname = multi.getParameter("fname");
	
	String upload = multi.getFilesystemName("upload");
	
	out.print("상품번호:"+no+"<br>");
	out.print("상품이름:"+name+"<br>");
	out.print("수량:"+qty+"<br>");
	out.print("가격:"+price+"<br>");
	out.print("원래파일명:"+fname+"<br>");
	out.print("새파일명:"+upload+"<br>");
	
	GoodsVo g  = new GoodsVo();
	g.setNo(no);
	g.setName(name);
	g.setQty(qty);
	g.setPrice(price);
	g.setFname(fname);
	
	if(upload != null){
		g.setFname(upload);	
	}
	
	GoodsDao dao = GoodsDao.getInstance();
	int re = dao.update(g);
	if(re == 1){
		if(upload != null){
			File file = new File(path + "/" + fname);
			file.delete();
		}
		
		response.sendRedirect("goods_list.jsp");
	}else{
		out.print("상품수정에 실패하였습니다.");
	}
%>


</body>
</html>














