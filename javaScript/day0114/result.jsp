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
	
	//������� �Է°����� Vo�� ��ƿ�.
	BoardVo b = new BoardVo(0,name,pwd,email,title,content,fname);
	
	//DB�� insert�� ����ϴ� Dao��ü�� �����ؿ�.
	BoardDao dao = new BoardDao();
	
	//Dao���� insert�� ���ѿ�.
	//insert �������θ� int������ ��ƿ�.
	int re = dao.insertBoard(b);

%>

re : <%= re  %>
<h4>�Է³����� ������ �����ϴ�.</h4>
<hr>
�̸� : <%= name %><br>
��ȣ : <%= pwd %><br>
�̸��� : <%= email %><br>
������ : <%= title %><br>
�۳��� : <%= content %><br>
���ϸ� : <%= fname %><br>



</body>
</html>







