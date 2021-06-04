package com.sist.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/sist/exam03/beans03.xml");
		Member member=(Member) context.getBean("member");
		member.pro();				
	}
}
