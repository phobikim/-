<%@page import="com.sist.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%
	ArrayList<Member> list = new ArrayList<Member>();
	list.add(new Member(1,"�̼���",20,"����","010-1111-1111"));
	list.add(new Member(2,"��ö��",50,"��õ","010-2222-2222"));
	list.add(new Member(3,"������",30,"����","010-1111-3333"));
	list.add(new Member(4,"������",40,"�λ�","010-1111-4444"));
	list.add(new Member(5,"������",60,"����","010-1111-5555"));
	
	%>
	<table class="table table-hover">
	<tr>
		<td>��ȣ</td>
		<td>�̸�</td>
		<td>����</td>
		<td>�ּ�</td>
		<td>��ȭ</td>
	</tr>	
	<%
	for(Member m:list){
		%>
			<tr>
				<td><%= m.getNo()%></td>
				<td><%= m.getName() %></td>
				<td><%= m.getAge() %></td>
				<td><%= m.getAddr() %></td>
				<td><%= m.getTel() %></td>
			</tr>
		<%
	}
	
%>
	</table>
</body>
</html>










