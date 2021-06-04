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
		System.out.println("도서"+book+"을 "+ cnt+"권 등록하였습니다.");
	}
}
