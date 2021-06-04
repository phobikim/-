<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkLogin(){
	let form = document.loginForm;
	if(form.id.value.trim() == ""){
		alert("아이디를 입력해주세요");
		form.id.value = "";
		form.id.focus();
		return false;
	}else if(form.passwd.value.trim() == ""){
		alert("비밀번호를 입력해주세요");
		form.passwd.value =  "";
		form.passwd.focus();
		return false;
	}
	
	form.submit();
	
}
</script>
</head>
<body>
	<form action="validation_loginOK.jsp" method="post" name="loginForm">
		<p>아이디 : <input type="text" name="id"> </p>
		<p>비밀번호 : <input type="password" name="passwd"> </p>
		<p><input type="button" value="전송" onclick="checkLogin()"></p>
	</form>
</body>
</html>