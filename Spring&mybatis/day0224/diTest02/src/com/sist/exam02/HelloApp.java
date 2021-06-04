package com.sist.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []config = {"com/sist/exam02/goods_beans.xml",
				"com/sist/exam02/member_beans.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(config);
		
		GoodsDao goodsDao = (GoodsDao)context.getBean("goodsDao");
		MemberDao memberDao = (MemberDao)context.getBean("memberDao");
		
		goodsDao.insertGoods();
		memberDao.insertMember();
		
	}

}





