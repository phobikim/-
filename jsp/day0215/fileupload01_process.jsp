<%@page import="java.util.Enumeration"%>
<%@page import="java.io.File"%>
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
	MultipartRequest multi = new MultipartRequest(request, "c:/upload", 
			1024*1024*5,"utf-8", new DefaultFileRenamePolicy());
	
	Enumeration params = multi.getParameterNames();
	while(params.hasMoreElements()){
		String name = (String)params.nextElement();
		String value = multi.getParameter(name);
		out.print(name+ "==>" + value + "<br>");
	}
	out.print("-----------------------------------------------<br>");
	
	Enumeration files  = multi.getFileNames();
	while(files.hasMoreElements()){
		String name = (String)files.nextElement();
		String filename = multi.getFilesystemName(name);
		String original = multi.getOriginalFileName(name);
		String type = multi.getContentType(name);
		File file = multi.getFile(name);
		
		out.print("요청 파마미터 이름:" + name+"<br>");
		out.print("실제 파일이름:"+original+"<br>");
		out.print("저장 파일이름:"+filename+"<br>");
		out.print("파일 컨텐츠 유형:"+type+"<br>");
		if(file != null){
			out.print("파일크기 : "+ file.length() + "<br");
		}
	}
	
	

/*
	String name = multi.getParameter("name");
	String subject = multi.getParameter("subject");
	String filename = multi.getFilesystemName("filename");
	File file  = multi.getFile("filename");
	long fileSize = file.length();

	out.print("이름:"+name+"<br>");
	out.print("제목:"+subject+"<br>");
	out.print("파일명:"+filename+"<br>");
	out.print("파일크기:"+fileSize+"<br>");
*/	
%>




</body>
</html>