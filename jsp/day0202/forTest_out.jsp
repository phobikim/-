<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	���: <select>
			<%
				for(int i=1; i<=12;i++){
					out.print("<option>"+i+"</option>");
				}
			%>
		</select>
</body>
</html>