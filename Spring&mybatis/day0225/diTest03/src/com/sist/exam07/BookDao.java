package com.sist.exam07;

public class BookDao {
	private Book book;
	private int cnt;
	
	
	public void setBook(Book book) {
		this.book = book;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	public void insertBook() {
		System.out.println("����"+book+"�� "+ cnt+"�� ����Ͽ����ϴ�.");
	}
}
