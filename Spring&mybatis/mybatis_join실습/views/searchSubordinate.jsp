<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>부하직원 검색</h2>
	
	<form action="searchSubordinate.do" method="post">
		관리자의 사원번호 : <input type="text" name="empno">
		<input type="submit" value="검색">
	</form>
	
	<table border="1" width="80%">
		<tr>
			<td>사원번호</td>
			<td>사원명</td>
			<td>부서번호</td>
			<td>부서명</td>
			<td>부서위치</td>
		</tr>
		<c:forEach var="e" items="${list }">
			<tr>
				<td>${e.EMPNO }</td>
				<td>${e.ENAME }</td>
				<td>${e.DEPTNO }</td>
				<td>${e.DNAME }</td>
				<td>${e.LOC }</td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>







