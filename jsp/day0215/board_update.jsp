<%@page import="com.sist.vo.BoardVo"%>
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
<h2>게시물 수정</h2>
<hr>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao dao = BoardDao.getInstance();
	BoardVo b =dao.getBoard(no, false);
%>

<form action="board_updateOK.jsp" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="<%=b.getNo()%>">
	글제목 : <input type="hi" name="title" value="<%=b.getTitle()%>"><br>
	작성자 : <input type="text" name="writer" value="<%=b.getWriter()%>"><br>
	글암호 : <input type="password" name="pwd" ><br>
	글내용 : <br>
	<textarea rows="10" cols="80" name="content"><%=b.getContent() %></textarea><br>
	<%=b.getFname() %>(<%=b.getFsize() %>)<br>
	
	<input type="hidden" name="fname" value="<%=b.getFname()%>">
	<input type="hidden" name="fsize" value="<%=b.getFsize()%>">
	
	파일 : <input type="file" name="upload"><br>
	<input type="submit" value="수정">
</form>
</body>
</html>









