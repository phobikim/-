<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
  
  //�ϳ��� ���ڸ� ���޹޾� ���ĺ����� �Ǻ��Ͽ� true, false�� ��ȯ�ϴ� �޼ҵ�
  function isAlpabethic(ch){
	  r = false;
	  if( ch >= 'a' && ch <= 'z'  ){
		  r = true;		  		  
	  }
	  return r;
  }
  
//�ϳ��� ���ڸ� ���޹޾� �������� �Ǻ��Ͽ� true, false�� ��ȯ�ϴ� �޼ҵ�
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
	 
		//�̸��Ͽ� ���� ����
		//@����
		//.com, co.kr, .net �� �������� �Ǻ�
		//@�� ù��° . ���̿��� ��� 2���� �̻�
		//@�տ��� ��� 2���� �̻�
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
				alert("���̵� �Է��ϼ���!");
				return;
			}			
			if(name == ""){
				alert("�̸��� �Է��ϼ���!");
				return;
			}			
			if(pwd == ""){
				alert("��й�ȣ�� �Է��ϼ���!");
				return;
			}			
			if(pwdChk == ""){
				alert("��й�ȣȮ���� �Է��ϼ���!");
				return;
			}			
			if(email == ""){
				alert("�̸����� �Է��ϼ���!");
				return;
			}
			
			//��ȣ�� ��ȣȮ���� ��ġ���� �ʴ��� �Ǻ�
			if(pwd != pwdChk){
				alert("��ȣ�� ��ȣȮ���� ��ġ���� �ʽ��ϴ�.");
				return;
			}
			
			// id�� ���� ����    �ѱۺҰ�, 5���� �̻�.
			if(id.length < 5){
				alert("id�� 5���� �̻����� �Է��ϼ���!");
				return;
			}			
			
			if(!isValid(id)){
				alert("���̵�� ������ ���ڷθ� �Է��� �ּ���!");
				return;
			}
			
			//��ȣ�� ���� ����
			//8�����̻�,����,����,!@#$
			if(!isPwd(pwd)){
				alert("��ȣ�� Ȯ���ϼ���!(8�����̻�,����,����, !@#$�� �Է��մϴ�.)");
				return;
			}
			
			
			
			
			//document.F.submit();
			
		}
	}
</script>
</head>
<body>
	<h2>ȸ������</h2>
	<form action="joinOK.jsp" method="post" name="F">
		���̵� : <input type="text" name="id" id="id"> 5���� �̻����� �Է��ϼ���<br>
		�̸� : <input type="text" name="name" id="name"><br>
		��й�ȣ : <input type="password" name="pwd" id="pwd"><br>
		��й�ȣȮ�� : <input type="password" name="pwdChk" id="pwdChk"><br>
		�̸��� : <input type="text" name="email" id="email"><br>
		<input id="btnOK" type="button" value="����">		
		<!-- <input id="btnOK" type="submit" value="����">-->
	</form>
	
	
</body>
</html>



