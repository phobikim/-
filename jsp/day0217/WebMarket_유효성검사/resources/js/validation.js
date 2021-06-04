//정규표현식과, input태그와, 오류메세지를 매개변수로 전달받아
//해당 input태그의 문자열이 정규표현식을 따르는지 판별하는 메소드를 정의


function pro(){
	alert("함수 호출됨");
}

function CheckAddProduct(){
	let prductId = document.getElementById("productId");
	let name = document.getElementById("name");
	let unitPrice = document.getElementById("unitPrice");
	let unitsInStock = document.getElementById("unitsInStock");
	
	if( !check(/^P[0-9]{4,11}/, prductId, "[상품코드]\nP와 숫자를 조합하여 5-12자까지 입력하세요\n첫글자는 반드시 P로 시작하세요") ){
		return false;
	}
	
	if(name.value.length < 4 || name.value.length > 12){
		alert("[상품명]\n최소 4자에서 최대 12자까지 입력하세요");
		name.select();
		name.focus();
		return false;
	}
	
	if(unitPrice.value.length==0 || isNaN(unitPrice.value)){
		alert("[가격]\n숫자만 입력하세요");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}
	
	if(unitPrice.value < 0){
		alert("[가격]\n음수는 입력할 수 없습니다");
		unitPrice.select();
		unitPrice.focus();
		return false;
	}else if( !check(/^\d+(?:[.]?[\d]?[\d]?$)/, unitPrice, "[가격]\n소수점 둘째 자리까지만 입력하세요")  ){
		return false;
	}
	
	if(isNaN(unitsInStock.value)){
		alert("[재고 수]\n숫자만 입력하세요");
		unitsInStock.select();
		unitsInStock.focus();
		return false;
	}
	
}









function check(regExp, e, msg){
	if(regExp.test(e.value)){
		return true;
	}
	alert(msg);
	e.select();
	e.focus();
	return false;
}













