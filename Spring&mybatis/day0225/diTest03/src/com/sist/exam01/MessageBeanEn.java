package com.sist.exam01;

public class MessageBeanEn {
	private String name;

	public MessageBeanEn(String name) {
		super();
		this.name = name;
	}
	public void sayHello() {
		System.out.println("hello, "+name);
	}
}
