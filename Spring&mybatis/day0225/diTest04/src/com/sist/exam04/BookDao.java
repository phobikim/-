package com.sist.exam04;

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
		System.out.println("도서"+book+"을 "+ cnt+"권 등록하였습니다.");
	}
}
