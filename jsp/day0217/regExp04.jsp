<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">


	function checkForm(){
		let name = document.frm.name.value;
		let regExp = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/
		if(!regExp.test(name)){
			alert("이름은 영문이거나 한글로 시작해야 합니다!")
			return false;
		}
		
		return true;
		
	}
</script>
</head>
<body>
	<form name="frm" action="regExp03_OK.jsp" method="post" onsubmit="return checkForm()">
		<p>이름: <input type="text" name="name" onkeypress="pro()">  
		<input type="submit" value="전송" >
		</p>
	</form>
</body>
</html>







