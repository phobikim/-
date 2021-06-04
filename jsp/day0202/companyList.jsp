<%@page import="com.sist.vo.Company"%>
<%@page import="java.util.ArrayList"%>
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
	ArrayList<Company> list = new ArrayList<Company>();
	list.add(new Company(1,"네이버", "http://www.naver.com"));
	list.add(new Company(2,"구글", "http://www.google.com"));
	list.add(new Company(3,"한빛", "http://www.hanb.co.kr"));
%>
<ul>
	<%
		for(Company c:list){
			%>
			<li>  <a href="<%=c.getUrl()%>"> <%=c.getName() %> </a>  </li>
			<%
		}
	%>
</ul>
</body>
</html>














