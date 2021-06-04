package com.sist.certification.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.certification.vo.Customer;

public class DBManager {
	
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/sist/certification/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	
	
	public static int delete(int no) {
		SqlSession session = factory.openSession();
		int re = session.delete("customer.delete",no);
		session.commit();
		session.close();
		return re;
	}
	
	public static int update(Customer c) {
		SqlSession session = factory.openSession();
		int re = session.update("customer.update",c);
		session.commit();
		session.close();
		return re;
	}
	
	public static int insert(Customer c) {
		SqlSession session = factory.openSession();
		int re = session.insert("customer.insert",c);
		session.commit();
		session.close();
		return re;
	}
	
	
	public static List<Customer> listCustomer(){
		List<Customer> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("customer.findAll");
		session.close();
		return list;
	}
	
}














