package com.sist.exam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context
		= new AnnotationConfigApplicationContext(SpringConfig.class);
		
		MemberService ms = (MemberService)context.getBean("member1");
		ms.update("tiger");
	}
}
