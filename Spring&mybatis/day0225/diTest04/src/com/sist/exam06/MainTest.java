package com.sist.exam06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(SistConfig.class);
		SistSystem sistSystem = (SistSystem)context.getBean("system");
		sistSystem.execute();
	}
}







