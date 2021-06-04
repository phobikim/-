package com.sist.vo;

public class FoodVo {
	private int no;
	private String name;
	public FoodVo(int no, String name) {
		super();
		this.no = no;
		this.name = name;
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
	public FoodVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FoodVo [no=" + no + ", name=" + name + "]";
	}
	
}
