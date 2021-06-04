package com.sist.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam03/beans03.xml");
		
		DeptDao dao = (DeptDao)context.getBean("deptDao");
		dao.insert();
	}
}
