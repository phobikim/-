package com.sist.exam06;

public class DeptDao {
	private Dept dept;
	private String manager;
	
	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public void insert() {
		System.out.println("부서를 등록하였습니다.");
		dept.info();
		System.out.println("관리자:"+manager);
	}
	
}
