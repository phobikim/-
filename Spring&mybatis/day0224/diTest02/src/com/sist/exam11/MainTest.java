package com.sist.exam11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam11/beans11.xml");
		
		BookDao dao = (BookDao)context.getBean("bookDao");
		dao.insertBook();
		
	}
}
