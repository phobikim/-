package com.sist.exam03;



public class DeptDao {
	private Dept dept;
	private String manager;
	public DeptDao(Dept dept, String manager) {
		super();
		this.dept = dept;
		this.manager = manager;
	}
	
	public void insert() {
		System.out.println("부서를 등록하였습니다.");
		dept.info();
		System.out.println("관리자:"+manager);
	}
	
}
