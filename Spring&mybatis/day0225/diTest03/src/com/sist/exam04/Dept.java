package com.sist.exam04;

public class Dept {
	private int dno;
	private String dname;
	private String dloc;
		
	public void setDno(int dno) {
		this.dno = dno;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setDloc(String dloc) {
		this.dloc = dloc;
	}

	public void info() {
		System.out.println("�μ���ȣ:"+dno);
		System.out.println("�μ��̸�:"+dname);
		System.out.println("�μ���ġ:"+dloc);
	}
}
