package com.sist.exam01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class HelloApp {

	public static void main(String[] args) {
		MessageBean bean = null;
		
		ApplicationContext context 
			= new ClassPathXmlApplicationContext("com/sist/exam01/beans01.xml");
		bean = (MessageBean)context.getBean("bean");		
		bean.sayHello("tiger");		
		
	}

}
