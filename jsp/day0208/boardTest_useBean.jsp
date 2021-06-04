<%@page import="com.sist.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BoardDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="oracle.net.aso.p"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
		BoardDao dao =  BoardDao.getInstance();
		String method =  request.getMethod();
		if(method.equals("POST")){
			%>
			<jsp:useBean id="b" class="com.sist.vo.BoardVo"/>
			<jsp:setProperty property="*" name="b"/>
			<%
			b.setIp(request.getRemoteAddr());
			int re = dao.insert(b);
			if(re == 1){
				out.print("<font color='blue'>게시물 등록에 성공하였습니다.</font>");
			}else{
				out.print("<font color='red'>게시물 등록에 실패하였습니다.</font>");
			}
		}
	%>

	<form action="boardTest.jsp" method="post">
		글제목 : <input type="text" name="title"><br>
		작성자 : <input type="text" name="writer"><br>
		암호 : <input type="password" name="pwd"><br>
		글내용 : <br>
		<textarea rows="10" cols="80" name="content"></textarea>
		<input type="submit" value="등록">
	</form>
	
	<h2>게시물 목록</h2>
	<table border="1" width="80%">
	<tr>
		<td>글번호</td>
		<td>글제목</td>
		<td>작성자</td>
		<td>조회수</td>
		<td>등록일</td>		
	</tr>
	<%
		ArrayList<BoardVo> list = dao.findAll();
		for(BoardVo b:list){
			out.print("<tr>");
			out.print("<td>"+b.getNo()+"</td>");
			out.print("<td>"+b.getTitle()+"</td>");
			out.print("<td>"+b.getWriter()+"</td>");
			out.print("<td>"+b.getHit()+"</td>");
			out.print("<td>"+b.getRegdate()+"</td>");
			out.print("</tr>");
		}
	%>
	</table>
</body>
</html>









