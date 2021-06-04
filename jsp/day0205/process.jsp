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
	String method = request.getMethod();

	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("irum");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String []hobby = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	String job = request.getParameter("job");
	String info = request.getParameter("info");
	
%>
<p>요청방식 : <%= method %><br>
<p>요청정보 길이 : <%= request.getContentLength() %></p>
<p>요청 URL : <%= request.getRequestURL() %></p>
<P>요청 URI : <%= request.getRequestURI() %></P>
<p>서버이름 : <%= request.getServerName() %></p>
<p>서버포트 : <%= request.getServerPort() %></p>
<p>ip주소 : <%= request.getRemoteAddr() %></p>

<hr>
<p>이름 : <%= name %></p>
<p>아이디 : <%= id %></p>
<p>암호 : <%= pwd %><br>
<p>취미 : 
	<%
		if(hobby!=null){
			for(String h:hobby){
				out.print(h+" ");
			}
		}
	%>
</p>

<p>성별 : <%=gender %></p>
<p>직업 : <%=job %></p>
<p>자기소개 : <%=info %><br>
</body>
</html>












