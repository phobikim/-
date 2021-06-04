<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
  
  //하나의 문자를 전달받아 알파벳인지 판별하여 true, false를 반환하는 메소드
  function isAlpabethic(ch){
	  r = false;
	  if( ch >= 'a' && ch <= 'z'  ){
		  r = true;		  		  
	  }
	  return r;
  }
  
//하나의 문자를 전달받아 숫자인지 판별하여 true, false를 반환하는 메소드
  function isNumeric(ch){
	 r = false ;
	 if( ch >= '0' && ch <= '9'  ){
		  r = true;		  		  
	  }
	 return r;
  }
  
 function isValid(data){
	 var r = true;
	 data2 = data.toLowerCase();
	 for(i=0; i<data2.length; i++){
		 ch = data2.charAt(i);
		 if(!isAlpabethic(ch) && !isNumeric(ch)){
			 r = false;
			 break;
		 }
	 }
	
	 return r;
 }

 
 //!@#$
 function isSpecial(ch){
	 r = false;
	 if(ch == '!' || ch == '@' || ch == '#' || ch == '$'){
		 r = true;
	 }
	 return r;
 }
  
 function isPwd(data){	 
	 var r = true;
	 data2 = data.toLowerCase();
	 
	 if(data2.length < 8){
		 return false;
	 }
	 
	 for(i=0; i<data2.length; i++){
		 ch = data2.charAt(i);
		 if(!isAlpabethic(ch) && !isNumeric(ch) &&!isSpecial(ch)){
			 r = false;
			 break;
		 }
	 }
	
	 return r;
 }
 

 function isValidEmail(email){
	 var r = true;
	 
		//이메일에 대한 제약
		//@포함
		//.com, co.kr, .net 로 끝나는지 판별
		//@과 첫번째 . 사이에는 적어도 2글자 이상
		//@앞에는 적어도 2글자 이상
		//tiger@naver.com
		var idx_at = email.indexOf("@");
		if(idx_at == -1){
			r = false;
			return r;
		}
		
		if(!email.endsWith(".com") && !email.endsWith(".co.kr")  && !email.endsWith(".net"))
		{
			r = false;
			return r;
		}
		
		//ti@nate.com
		//012
		
		if(idx_at < 2){
			r = false;
			return r;
		}
		
		//tiger@aaa.co.kr
		
		var idx_dot = email.indexOf(".");
		if(idx == -1){
			r = false;
			return r;
		}
		
		if( (idx_dot - idx_at) < 2 ){
			r = false;
			return r;
		}
		
 }
 
  
  
	window.onload = function(){
		var btnOK = document.getElementById("btnOK");
		btnOK.onclick = function(){
			var id = document.getElementById("id").value.trim();
			var name = document.getElementById("name").value.trim();
			var pwd = document.getElementById("pwd").value.trim();
			var pwdChk = document.getElementById("pwdChk").value.trim();
			var email = document.getElementById("email").value.trim();
			/*
			var r = "";
			r += "id:"+id + "\n";
			r += "name:"+name + "\n";
			r += "pwd:"+pwd + "\n";
			r += "pwdChk:"+pwdChk + "\n";
			r += "email:"+email;
			
			alert(r);*/
			
			if(id == ""){
				alert("아이디를 입력하세요!");
				return;
			}			
			if(name == ""){
				alert("이름을 입력하세요!");
				return;
			}			
			if(pwd == ""){
				alert("비밀번호를 입력하세요!");
				return;
			}			
			if(pwdChk == ""){
				alert("비밀번호확인을 입력하세요!");
				return;
			}			
			if(email == ""){
				alert("이메일을 입력하세요!");
				return;
			}
			
			//암호와 암호확인이 일치하지 않는지 판별
			if(pwd != pwdChk){
				alert("암호와 암호확인이 일치하지 않습니다.");
				return;
			}
			
			// id에 대한 제약    한글불가, 5글자 이상.
			if(id.length < 5){
				alert("id는 5글자 이상으로 입력하세요!");
				return;
			}			
			
			if(!isValid(id)){
				alert("아이디는 영문과 숫자로만 입력해 주세요!");
				return;
			}
			
			//암호에 대한 제약
			//8글자이상,영문,숫자,!@#$
			if(!isPwd(pwd)){
				alert("암호를 확인하세요!(8글자이상,영문,숫자, !@#$로 입력합니다.)");
				return;
			}
			
			
			
			
			//document.F.submit();
			
		}
	}
</script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="joinOK.jsp" method="post" name="F">
		아이디 : <input type="text" name="id" id="id"> 5글자 이상으로 입력하세요<br>
		이름 : <input type="text" name="name" id="name"><br>
		비밀번호 : <input type="password" name="pwd" id="pwd"><br>
		비밀번호확인 : <input type="password" name="pwdChk" id="pwdChk"><br>
		이메일 : <input type="text" name="email" id="email"><br>
		<input id="btnOK" type="button" value="가입">		
		<!-- <input id="btnOK" type="submit" value="가입">-->
	</form>
	
	
</body>
</html>



