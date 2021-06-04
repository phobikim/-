package com.sist.exam11;

public class Book {
	private int no;
	private String name;
	private int price;
	private String publisher;
	
	
	
	
	public void setNo(int no) {
		this.no = no;
	}




	public void setName(String name) {
		this.name = name;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}




	@Override
	public String toString() {
		return "Book [no=" + no + ", name=" + name + ", price=" + price + ", publisher=" + publisher + "]";
	}	
	
	
}
