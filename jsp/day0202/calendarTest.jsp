<%@page import="java.util.Date"%>
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
	
		int lastDate[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		System.out.println("��û�� ����:"+year);
		System.out.println("��û�� ��:"+month);
	
		String []day_str = {"��","��","ȭ","��","��","��","��"};
		Date today = new Date();
		int thisYear = today.getYear();
		int thisMonth = today.getMonth();
		
		int yoil = (new Date(thisYear, thisMonth,1)).getDay();
	%>	
	<H2><%= thisYear+1900 %>�� <%= thisMonth+1 %>��</H2>
	
	<a href="calendarTest.jsp?year=<%=thisYear %>&month=<%=thisMonth+1%>">���� ��</a>
	<table border="1">
		<tr>
			<%
				for(String day:day_str)
				{
					%>
					<td>  <%=day %> </td>
					<%
				}
			%>
		</tr>
		
		
		<tr>
			<%
				for(int i=1;i<=yoil;i++){
					%>
					<td>&nbsp;</td>
					<%
				}
			
			
				for(int i=1; i<=lastDate[thisMonth]; i++)
				{
					%>
					<td><%=i %></td>
					<%
						if( (i+yoil) % 7 == 0){
							%>
							</tr><tr>
							<%
						}
			
				}
			%>			
		</tr>
	</table>
</body>

</html>
