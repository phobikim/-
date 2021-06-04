<%@page import="com.sist.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BoardDao"%>
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
	BoardDao dao = BoardDao.getInstance();
	ArrayList<BoardVo> list  = dao.findAll();
%>

<h2>게시물 목록</h2>
<hr>
<a href="board_insert.jsp">게시물 등록</a><br>
<table border="1" width="80%">
	<tr>
		<th>글번호</th>
		<th>글제목</th>
		<th>작성자</th>
		<th>파일명(파일크기)</th>
	</tr>
	<%
		for(BoardVo b :list){
			out.println("<tr>");
			out.println("<td>"+b.getNo()+"</td>");
			out.println("<td><a href='board_detail.jsp?no="+b.getNo()+"'>"+b.getTitle()+"</a></td>");
			out.println("<td>"+b.getWriter()+"</td>");
			out.println("<td>"+b.getFname()+"("+b.getFsize()+"bytes)</td>");
			out.println("</tr>");
		}
	%>
	
</table>
</body>
</html>









