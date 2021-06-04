<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#joinForm{
	visibility: hidden;
}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		let code ;
	
		$("#btnSendCode").click(function(){			
			let data = $("#checkForm").serializeArray();
			$.ajax({url:"/sendCode.do", data:data, success:function(data){			
				code = data;			
				alert(code);
			}});
		});
	});
</script>
</head>
<body>

<form id="checkForm">
	<input type="radio" name="type"  value="email">이메일인증
	<input type="radio" name="type"  value="phone">휴대폰인증
	<input type="text" name="to" >
</form>

<button id="btnSendCode">인증코드전송</button>
코드입력 : <input type="text" name="code">
<button>확인</button>

<div id="joinForm">
	<h2>회원가입</h2>
	<hr>
	<form action="join.do" method="post">
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="text" name="email"><br>
		전화 : <input type="text" name="phone"><br>
		<input type="submit" value="등록">
	</form>
</div>

</body>
</html>










