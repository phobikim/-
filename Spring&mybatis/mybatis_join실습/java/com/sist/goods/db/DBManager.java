package com.sist.goods.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.sist.goods.vo.SearchEmp;

public class DBManager {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader
			= Resources.getResourceAsReader("com/sist/goods/db/dbConfig.xml");
			
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	
	public static List<Map> searchSubordinate(HashMap map) {
		SqlSession session = factory.openSession();
		List<Map> list =  session.selectList("emp.searchSubordinate", map);
		System.out.println(list);
		session.close();
		return list;
		
	}
	
	public static List<SearchEmp> seachEmp(HashMap map){
		SqlSession session = factory.openSession();
		List<SearchEmp>  list = session.selectList("emp.searchEmp",map);
		session.close();
		return list;
	}
	
	
	
}










