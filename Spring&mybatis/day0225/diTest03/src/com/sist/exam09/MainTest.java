package com.sist.exam09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam09/beans09.xml");
		BookDao dao = (BookDao)context.getBean("bookDao");
		dao.insertBook();

	}

}
