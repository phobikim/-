<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkForm(){
		let name = document.getElementById("name").value;
		if(name.length < 6 || name.length >12){
			alert("이름을 6~12자 이내로 입력해주세요");
			document.getElementById("name").select();
			return false;
		}
		
		if( !isNaN(name.substr(0,1))){
			alert("이름은 숫자로 시작할수 없습니다.");
			document.getElementById("name").select();
			return false;
		}
		
		document.F.submit();
		
	}
</script>
</head>
<body>
<form  name="F"  action="validation_result.jsp" method="post">
	이름 : <input type="text" name="name" id="name">
	<input type="button" value="전송" onclick="checkForm()">
</form>
</body>
</html>