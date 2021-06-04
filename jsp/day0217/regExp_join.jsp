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
		
		let form = document.Member;
		
		let id = form.id.value.trim();
		let name = form.name.value.trim();
		
		if(!regExpId.test(id)){
			alert("아이디는 문자로 시작해주세요!");
			form.id.select();
			return false;
		}
		
		if(name == ""){
			alert("이름을 입력하세요!");
			return false;
		}
				
		if(!regExpName.test(name)){
			alert("이름은 한글만 입력해주세요!");
			form.name.select();
			return false;
		}
		
		
		
		return true;
	}

</script>
</head>
<body>
	<h3>회원가입</h3>
	<form action="regExp_joinOK.jsp" method="post" name="Member" onsubmit="return checkMember()">
		<p>아이디 : <input type="text" name="id" required="required" > </p>
		<p>비밀번호 : <input type="password" name="passwd" required="required"> </p>
		<p>이름 : <input type="text" name="name" required="required"> </p>
		<p>연락처 : 
			<input type="tel" pattern="(010)-\d{3,4}-\d{4}" name="phone" required="required">
		</p>
		<p>이메일 : <input type="email" name="email" required="required"> </p>
		<p><input type="submit" value="가입하기">  </p>
	</form> 
</body>
</html>



