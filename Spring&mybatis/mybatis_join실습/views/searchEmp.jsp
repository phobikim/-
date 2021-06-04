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
	<h2>부서번호별 사원검색</h2>
	<hr>
	
	<form action="searchEmp.do" method="post">
		부서번호 : <input type="text" name="deptno">
		<input type="submit" value="검색">
	</form>
	
	
	<hr>
	<table border="1" width="80%">
		<tr>
			<td>사원번호</td>
			<td>사원명</td>
			<td>급여</td>
			<td>부서번호</td>
			<td>부서명</td>
			<td>부서위치</td>
		</tr>
		
		<c:forEach var="e" items="${list }">
			<tr>
				<td>${e.empno }</td>
				<td>${e.ename }</td>
				<td>${e.sal }</td>
				<td>${e.deptno }</td>
				<td>${e.dname }</td>
				<td>${e.loc }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>









