function isValidSocialNumber(number){
	let re = false;
	let arr = [2,3,4,5,6,7,8,9,2,3,4,5];
	let tot = 0;
	
	
	let check = number.charAt(12);
	for(i = 0; i<number.length-1; i++){
		  tot +=  arr[i] * number.charAt(i) ;
	}
	tot %= 11;  
	tot = 11-tot;
	if(tot >= 10 ){
		tot -= 10;
	}
	
	if(tot == check){
		re = true;
	}
		
	return re;
}