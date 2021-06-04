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
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao dao = BoardDao.getInstance();
	BoardVo b= dao.getBoard(no, true);
	// getBoard메소드는 글번호와 조회수 증가여부를 boolean으로 받도록 정의 되어 있어요.
	// 지금은 상세보기를 위한 jsp이므로 조회수를 증가해야 해요.
	// 그래서 true를 전달합니다.
	
	//content의 내용중에 개행문자(\n)을 모두 <br>로 바꾸어요
	String content = b.getContent();
	content = content.replace("\n", "<br>");
	
%>

<h2>게시물 상세</h2>
<hr>
글번호 : <%= b.getNo() %><br>
글제목 : <%= b.getTitle() %><br>
작성자 : <%= b.getWriter() %><br>
글내용 : <br>
<%= content %><br>
ip주소 : <%= b.getIp() %><br>
등록일 : <%= b.getRegdate() %><br>
첨부파일명 : <%= b.getFname() %><br>
파일크기 <%= b.getFsize() %><br>
조회수 : <%= b.getHit() %><br>
<hr>

</body>
</html>











