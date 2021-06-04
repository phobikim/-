<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	MultipartRequest multi = new MultipartRequest(request,
			"c:\\upload",
			1024*1024*5,
			"utf-8",
			new DefaultFileRenamePolicy());

	String title = multi.getParameter("title");
	out.print("<h3>"+title+"</h3>");
	
	Enumeration files = multi.getFileNames();
	String name = (String)files.nextElement();
	//fileName
	
	out.print("태그이름:"+name+"<br>");
	
	//String filename = multi.getFilesystemName("fileName");
	String filename = multi.getFilesystemName(name);
	String original = multi.getOriginalFileName(name);
	
	out.print("실제 파일 이름:"+original+"<br>");
	out.print("저장 파일 이름:"+filename+"<br>");
	
%>


</body>
</html>








