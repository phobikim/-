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
		System.out.println("�μ��� ����Ͽ����ϴ�.");
		dept.info();
		System.out.println("������:"+manager);
	}
	
}
