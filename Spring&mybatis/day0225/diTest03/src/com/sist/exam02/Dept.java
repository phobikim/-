package com.sist.exam02;

public class Dept {
	private int dno;
	private String dname;
	private String dloc;
	public Dept(int dno, String dname, String dloc) {
		super();
		this.dno = dno;
		this.dname = dname;
		this.dloc = dloc;
	}
	public void info() {
		System.out.println("�μ���ȣ:"+dno);
		System.out.println("�μ��̸�:"+dname);
		System.out.println("�μ���ġ:"+dloc);
	}
}
