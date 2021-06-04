<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="oracle.net.aso.p"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
	
	
		String method =  request.getMethod();
		if(method.equals("POST")){
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String pwd = request.getParameter("pwd");
			String content = request.getParameter("content");
			String ip = request.getRemoteAddr();
			String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,sysdate,0)";
			
			try{
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, writer);
				pstmt.setString(2, pwd);
				pstmt.setString(3, title);
				pstmt.setString(4, content);
				pstmt.setString(5, ip);
				int re = pstmt.executeUpdate();
				if(re == 1){
					out.print("<font color='blue'>게시물 등록에 성공하였습니다.</font>");
				}else{
					out.print("<font color='red'>게시물 등록에 실패하였습니다.</font>");
				}	
				
				if(pstmt != null){
					pstmt.close();
				}
				
			}catch(Exception e){
				System.out.println("예외발생:"+e.getMessage());
			}
		}
	%>


	<form action="boardTest.jsp" method="post">
		글제목 : <input type="text" name="title"><br>
		작성자 : <input type="text" name="writer"><br>
		암호 : <input type="password" name="pwd"><br>
		글내용 : <br>
		<textarea rows="10" cols="80" name="content"></textarea>
		<input type="submit" value="등록">
	</form>
	
	<h2>게시물 목록</h2>
	<table border="1" width="80%">
	<tr>
		<td>글번호</td>
		<td>글제목</td>
		<td>작성자</td>
		<td>조회수</td>
		<td>등록일</td>		
	</tr>
	<%
		String sql = "select no,title,writer,hit,regdate from board";
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				out.print("<tr>");
				out.print("<td>"+rs.getInt(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getString(3)+"</td>");
				out.print("<td>"+rs.getInt(4)+"</td>");
				out.print("<td>"+rs.getDate(5)+"</td>");
				out.println("</tr>");
			}
			
			if(rs != null){
				rs.close();
			}
			
			if(stmt != null){
				stmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
			
		}catch(Exception e){
			System.out.println("예외발생:"+e.getMessage());
		}
	%>
	</table>
</body>
</html>









