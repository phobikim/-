package com.sist.exam05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext context
		= new ClassPathXmlApplicationContext("com/sist/exam05/beans05.xml");
		DeptDao dao= (DeptDao)context.getBean("deptDao");
		dao.insert();

	}

}
