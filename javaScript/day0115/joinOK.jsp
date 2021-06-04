<%@page import="com.sist.dao.MemberDao"%>
<%@page import="com.sist.vo.MemberVo"%>
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
	MemberVo b = new MemberVo();
	b.setId(request.getParameter("id"));
	b.setName(request.getParameter("name"));
	b.setPwd(request.getParameter("pwd"));
	b.setEmail(request.getParameter("email"));
	
	MemberDao dao = MemberDao.getInstance();
	int re = dao.insertMember(b);
	if(re > 0){
		%>
		회원가입에 성공하였습니다.
		<%
	}else{
		%>
		회원가입에 실패하였습니다.
		<%
	}
	
%>
</body>
</html>







