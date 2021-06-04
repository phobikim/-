<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkMember(){
		let regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		let regExpName =/^[가-힣]*$/;
		let regExpPasswd = /^[0-9]*$/;
		let regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
		let regExpEmail = /^[0-9|a-z|A-Z]([-_\.]?[0-9|a-z|A-Z])*@[0-9|a-z|A-Z]([-_\.]?[0-9|a-z|A-Z])*\.[a-z|A-Z]{2,3}$/i
		
		let form = document.Member;
		
		let id = form.id.value.trim();
		let name = form.name.value.trim();
		let passwd = form.passwd.value.trim();
		let phone = form.phone1.value + '-' + form.phone2.value.trim() +"-"+ form.phone3.value.trim();
		let email = form.email.value.trim();
		
		if(!regExpId.test(id)){
			alert("아이디는 문자로 시작해주세요!");
			form.id.select();
			return false;
		}
		
		if(name == ""){
			alert("이름을 입력하세요!");
			return false;
		}
		
		if(passwd == ""){
			alert("비밀번호를 입력하세요!");
			return false;
		}
		
		
		
		if(!regExpName.test(name)){
			alert("이름은 한글만 입력해주세요!");
			form.name.select();
			return false;
		}
		
		if(!regExpPasswd.test(passwd)){
			alert("비밀번호는 숫자만 입력해주세요!");
			form.passwd.select();
			return false;
		}
		
		if(!regExpPhone.test(phone)){
			alert("연락처 입력을 확인해주세요!");
			form.phone2.select();
			return false;
		}
		
		if(!regExpEmail.test(email)){
			alert("이메일 입력을 확인해주세요!");
			form.email.select();
			return false;
		}
		
		return true;
	}

</script>
</head>
<body>
	<h3>회원가입</h3>
	<form action="regExp_joinOK.jsp" method="post" name="Member" onsubmit="return checkMember()">
		<p>아이디 : <input type="text" name="id"> </p>
		<p>비밀번호 : <input type="password" name="passwd"> </p>
		<p>이름 : <input type="text" name="name"> </p>
		<p>연락처 : <select name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
				   </select> 
				   -
				   <input type="text" name="phone2" maxlength="4" size="4">
				   -
				   <input type="text" name="phone3" maxlength="4" size="4">
				   </p>
		<p>이메일 : <input type="text" name="email"> </p>
		<p><input type="submit" value="가입하기">  </p>
	</form> 
</body>
</html>



