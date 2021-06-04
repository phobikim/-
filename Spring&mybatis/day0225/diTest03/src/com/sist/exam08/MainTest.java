package com.sist.exam08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam08/beans08.xml");
		
		ProtocolHandler ph = (ProtocolHandler)context.getBean("ph");
		ph.execute();
	}

}
