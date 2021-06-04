<%@page import="java.io.File"%>
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
	//해당상품을 삭제한 후 파일도 삭제하려면 
	//그 파일이 있는 실제 경로를 알아야 합니다.
	String path = request.getRealPath("upload");

	int no = Integer.parseInt(request.getParameter("no"));
	GoodsDao dao = GoodsDao.getInstance();

	//상품을 삭제하기 전에 해당상품의 파일명을 알아야 해요!
	String fname = dao.findByNo(no).getFname();
	
	
	int re = dao.deleteByNo(no);
	
	if(re == 1){
		File file = new File(path + "/" + fname);
		file.delete();
		response.sendRedirect("goods_list.jsp");
	}else{
		out.println("상품삭제에 실패하였습니다.");
	}
%>
</body>
</html>








