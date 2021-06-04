<%@page import="com.sist.dao.BoardDao"%>
<%@page import="com.sist.vo.BoardVo"%>
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
	String path = request.getRealPath("upload");
	System.out.println(path);
	
	MultipartRequest multi = new MultipartRequest(request, path,
			1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
	//이때 클라이언트가 업로드한 파일이 서버에 저장됩니다.
	//그리고 클라이언트가 입력한 정보들도 multi객체에 담기게 됩니다.
	
	int no = Integer.parseInt(multi.getParameter("no"));
	String writer = multi.getParameter("writer");
	String pwd = multi.getParameter("pwd");
	String title = multi.getParameter("title");
	String content = multi.getParameter("content");
	File file = multi.getFile("upload");
	
	String oldFname = multi.getParameter("fname");
	int oldFsize = Integer.parseInt(multi.getParameter("fsize"));
	
	
	String fname = oldFname;
	int fsize = oldFsize;
	if(file != null){
		fname = multi.getFilesystemName("upload");
		fsize = (int)file.length();
	}
	
	BoardVo b = new BoardVo(no,writer,pwd,title,content,null,null,0,fname,fsize);
	BoardDao dao = BoardDao.getInstance();
	int re = dao.update(b);
	if(re == 1){      //파일은 수정할 수도 있고 수정하지 않을 수도 있도록 하려는데
					// 파일을 수정 안했는데도 삭제가 일어 날 수 있따.
		if(file != null){
			File oldFile = new File(path +"/" + oldFname);
			oldFile.delete();
		}
		response.sendRedirect("board_list.jsp");
	}else{
		out.print("실패");
	}
	
%>
</body>
</html>





