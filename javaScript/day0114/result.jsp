<%@page import="com.sist.dao.BoardDao"%>
<%@page import="com.sist.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%

	request.setCharacterEncoding("euc-kr");
	String name;
	name = request.getParameter("name");
	
	String pwd = request.getParameter("pwd");
	String email_1 = request.getParameter("email_1");
	String email_2 = request.getParameter("email_2");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String fname = request.getParameter("fname");
	
	String email = email_1 + "@" + email_2;
	
	//사용자의 입력값들을 Vo에 담아요.
	BoardVo b = new BoardVo(0,name,pwd,email,title,content,fname);
	
	//DB에 insert를 담당하는 Dao객체를 생성해요.
	BoardDao dao = new BoardDao();
	
	//Dao에게 insert를 시켜요.
	//insert 성공여부를 int변수에 담아요.
	int re = dao.insertBoard(b);

%>

re : <%= re  %>
<h4>입력내용은 다음과 같습니다.</h4>
<hr>
이름 : <%= name %><br>
암호 : <%= pwd %><br>
이메일 : <%= email %><br>
글제목 : <%= title %><br>
글내용 : <%= content %><br>
파일명 : <%= fname %><br>



</body>
</html>







