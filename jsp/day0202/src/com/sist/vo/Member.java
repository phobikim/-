package com.sist.vo;

public class Member {
	private int no;
	private String name;
	private int age;
	private String addr;
	private String tel;
	public Member(int no, String name, int age, String addr, String tel) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.addr = addr;
		this.tel = tel;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
