<%@page import="com.sist.vo.Member"%>
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
	ArrayList<Member> list = new ArrayList<Member>();
	list.add(new Member(1,"�̼���",20,"����","010-1111-1111"));
	list.add(new Member(2,"��ö��",50,"��õ","010-2222-2222"));
	list.add(new Member(3,"������",30,"����","010-1111-3333"));
	list.add(new Member(4,"������",40,"�λ�","010-1111-4444"));
	list.add(new Member(5,"������",60,"����","010-1111-5555"));
	
	%>
	<table border="1">
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










