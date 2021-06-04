<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.canUse{
		color: blue;
	}
	
	.cantUse{
		color: red;
	}
</style>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btnIdCheck").click(function(){
		let data = {id:$("#id").val()}
		$.ajax({url:"idCheck.jsp",data:data,success:function(data){
			let r = $("#id").val()+ "는 사용할 수 있습니다.";
			$("#result_idCheck").removeClass("cantUse");
			$("#result_idCheck").addClass("canUse");
			if(data.msg == 1){
				r = $("#id").val()+ "는 사용할 수 없습니다.";
				$("#result_idCheck").removeClass("canUse");
				$("#result_idCheck").addClass("cantUse");
			}
			
			$("#result_idCheck").html(r);
		}});
	});
})
</script>
</head>
<body>
<h3>회원 가입</h3>
<form action="insertMemberOK_print.jsp" method="post" name="member">
<!-- <form action="insertMemberOK.jsp" method="post" name="member">-->
	<p>아이디 : <input type="text" name="id" id="id">
		<input type="button" value="아이디 중복 검사" id="btnIdCheck">
		<span id="result_idCheck"></span>
	</p>
	<p>비밀번호 : <input type="password" name="passwd"></p>
	<p>이름 : <input type="text" name="name">  </p>
	<p>
		연락처 : 
		<select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="019">019</option>
		</select>
		-
		<input type="text" maxlength="4" size="4" name="phone2">-
		<input type="text" maxlength="4" size="4" name="phone3"> 
	</p>
	<p>
		성별 : <input name="sex"  type="radio" value="남성" checked="checked">남성
		<input name="sex"  type="radio" value="여성">여성
	</p>
	
	<p>
		혈액형 :	<input name="bloodType" type="radio" value="A">A 
		<input name="bloodType" type="radio" value="B">B
		<input name="bloodType" type="radio" value="AB">AB
		<input name="bloodType" type="radio" value="O">O
	</p>
	
	<p>
		취미: <input type="checkbox" name="hobby" value="독서">독서	
		<input type="checkbox" name="hobby" value="운동" checked="checked">운동
		<input type="checkbox" name="hobby" value="영화">영화
	</p>
	
	<p>
		지역 : 
		<select name="city" >
			<option value="서울특별시">서울특별시</option>
			<option value="경기도">경기도</option>
			<option value="인천광역시" selected="selected">인천광역시</option>
			<option value="충청도">충청도</option>
			<option value="전라도">전라도</option>
			<option value="경상도">경상도</option>			
			<option value="제주도">제주도</option>
		</select>
	</p>
	<p>
	<textarea name="info" rows="3" cols="30" placeholder="가입 인사를 입력해주세요"></textarea>
	</p>
	<p>
		<input type="submit" value="가입하기">
		<input type="reset" value="다시쓰기">
	</p>
</form>





</body>
</html>