<%@page import="com.sist.dao.BoardDao"%>
<%@page import="com.sist.vo.BoardVo"%>
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
	String path = request.getRealPath("board_upload");
	MultipartRequest multi = new MultipartRequest(request, 
			path,
			1024*1024*5,
			"utf-8",
			new DefaultFileRenamePolicy());
	
	String writer = multi.getParameter("writer");
	String pwd = multi.getParameter("pwd");
	String title = multi.getParameter("title");
	String content = multi.getParameter("content");
	String ip = request.getRemoteAddr();
	String fname = multi.getFilesystemName("fname");
	
	BoardVo b = new BoardVo();
	b.setWriter(writer);
	b.setPwd(pwd);
	b.setTitle(title);
	b.setContent(content);
	b.setIp(ip);
	b.setFname(fname);
	
	BoardDao dao = BoardDao.getInstance();
	int re = dao.insert(b);
	
	if(re == 1){
		out.print("성공!");
	}else{
		out.print("실패!");
	}
	
	
%>
</body>
</html>






