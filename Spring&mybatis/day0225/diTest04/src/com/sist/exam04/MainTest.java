package com.sist.exam04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		= new AnnotationConfigApplicationContext(BeanConfig.class);
		BookDao dao = (BookDao)context.getBean("bookDao");
		dao.insertBook();
	}

}
