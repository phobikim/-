package com.sist.exam05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(BeansConfig.class);
		
		SistSystem system=(SistSystem) context.getBean("system");
		system.execute();
	}
}










