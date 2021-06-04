package com.sist.exam08;

public class HeaderFilter implements Filter {

	@Override
	public void execute() {
		System.out.println("HeaderFilter의 실행입니다.");
	}
}
