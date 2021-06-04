<%@page import="com.sist.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 목록</h2>
<hr>

<%
	BoardDao dao = new BoardDao();
	ArrayList<BoardVo> list = dao.arrRecord();	
%>
<table border="1" width="80%">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>제목</th>
		<th>이메일</th>
	</tr>
	<%
		for(BoardVo b:list){
			%>
				<tr>
					<td><%= b.getNo() %>  </td>
					<td><%= b.getName() %>  </td>
					<td><%= b.getTitle() %> </td>
					<td><%= b.getEmail() %> </td>
				</tr>
			<%
		}
	%>	
</table>

</body>
</html>













