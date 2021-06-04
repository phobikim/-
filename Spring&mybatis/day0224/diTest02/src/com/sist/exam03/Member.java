package com.sist.exam03;

public class Member {
	private String name;

	public void pro() {
		System.out.println("member의  pro입니다.");
	}
	
	
	
	public Member(String name) {
		super();
		this.name = name;
		System.out.println("매개변수를 갖는 생성자 동작함!");
	}
	

	public Member() {
		System.out.println("기본생성자 동작함!");
	}	
	
}
