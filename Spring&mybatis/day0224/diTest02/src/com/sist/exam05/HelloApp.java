package com.sist.exam05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		ApplicationContext context 
			= new ClassPathXmlApplicationContext("com/sist/exam05/beans05.xml");
		
		WriteArticleServiceImpl ws =(WriteArticleServiceImpl) context.getBean("ws");
		
		ws.execute();
		
	}
}
