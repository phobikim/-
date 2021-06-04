<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	let regExp = /colou?r/;
	let data = "hello colouur java";
	if(regExp.test(data)){
		alert("패턴을 따릅니다.");
	}else{
		alert("패턴을 따르지 않습니다.");
	}
	
			
</script>
</head>
<body>

</body>
</html>