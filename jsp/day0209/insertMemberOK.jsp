<%@page import="com.sist.dao.MemberDao"%>
<%@page import="com.sist.vo.MemberVo"%>
<%@page import="java.util.Arrays"%>
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
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String sex  = request.getParameter("sex");
	String bloodType = request.getParameter("bloodType");
	
	String []hobbyArr = request.getParameterValues("hobby");
	// 취미는 체크박스로 표현되어 있어 여러개를 선택할 수 있어요.
	// 그래서 배열로 받아야 합니다.
	
	String hobby = Arrays.toString(hobbyArr);
	//배열의 내용을 문자열로 만들어 줍니다.

	String city = request.getParameter("city");
	String info = request.getParameter("info");
	
	MemberVo m = new MemberVo();
	m.setId(id);
	m.setPasswd(passwd);
	m.setName(name);
	m.setPhone1(phone1);
	m.setPhone2(phone2);
	m.setPhone3(phone3);
	m.setSex(sex);
	m.setBloodtype(bloodType);
	m.setHobby(hobby);
	m.setCity(city);
	m.setInfo(info);
	
	MemberDao dao = MemberDao.getInstance();
	int re = dao.insert(m);
	if(re == 1){
		out.print("회원을 등록하였습니다.");	
	}else{
		out.print("회원등록에 실패하였습니다.");
	}
%>
</body>
</html>












