<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<%@ include file="menu.jsp" %>
<%!

	String greeting = "웹 쇼핑몰에 오신 것을 환영합니다.";
	String tagline = "Welcome to Web Market!";
%>

<%
	response.setIntHeader("Refresh", 5);
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
				out.print("현재 접속 시각:"+CT+"<br>");	
			%>
		</div>
	</div>
</main>

<%@ include file="footer.jsp" %>
</body>
</html>















