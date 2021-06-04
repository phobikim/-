<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkForm(){
		let str = document.frm.title.value;
		//let regExp = new RegExp("java", 'i');
		let regExp = /java/i;
		if(regExp.test(str)){
			alert("java 문자열을 포함하고 있어요");
		}else{
			alert("java 문자열을 포함하고 있지 않아요");
		}
	}
</script>
</head>
<body>
	<form name="frm">
		<p>제목: <input type="text" name="title">  
		<input type="button" value="전송" onclick="checkForm()">
		</p>
	</form>
</body>
</html>