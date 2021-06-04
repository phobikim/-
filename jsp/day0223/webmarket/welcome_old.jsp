<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Welcome</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a  class="navbar-brand" href="./welcome.jsp">Home</a>
			</div>
		</div>
	</div>
<%!
	String greeting = "�� ���θ��� ���� ���� ȯ���մϴ�.";
	String tagline = "Welcome to Web Market!";
%>

<div class="jumbotron">
	<div class="container">
		<h1 class="display-3"> <%=greeting %> </h1>
	</div>
</div>

<main role="main">
	<div class="container">
		<div class="text-center">
			<h3> <%= tagline %></h3>
			<%
				String am_pm="";
				Calendar day = Calendar.getInstance();
				int hour = day.get(Calendar.HOUR_OF_DAY);
				int minutes = day.get(Calendar.MINUTE);
				int seconds = day.get(Calendar.SECOND);
				
				if(hour/12==0){
					am_pm ="AM";
				}else{
					am_pm = "PM";
					hour = hour - 12; 
				}
				
				String CT = hour+":"+minutes + ":"+seconds+" "+am_pm;
				out.print("���� ���� �ð�:"+CT+"<br>");	
			%>
		</div>
	</div>
</main>

<footer class="container">
	<p>&copy; WebMarket</p>
</footer>
</body>
</html>















