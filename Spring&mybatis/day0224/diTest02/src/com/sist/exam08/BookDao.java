package com.sist.exam08;

public class BookDao {
	private Book book;
	private int cnt;
	public BookDao(Book book, int cnt) {
		super();
		this.book = book;
		this.cnt = cnt;
	}
	
	public void insertBook() {
		System.out.println("����"+book+"�� "+ cnt+"�� ����Ͽ����ϴ�.");
	}
}
