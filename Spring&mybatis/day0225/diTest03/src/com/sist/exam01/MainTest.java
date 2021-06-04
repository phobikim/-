package com.sist.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("com/sist/exam01/beans.xml");
		MessageBeanEn mb = (MessageBeanEn)context.getBean("mb");
		mb.sayHello();
	}
}
