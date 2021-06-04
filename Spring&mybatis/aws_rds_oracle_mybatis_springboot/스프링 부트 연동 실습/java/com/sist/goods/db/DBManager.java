package com.sist.goods.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.goods.vo.MemberVo;



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
	
	
	public static List<MemberVo> findAll(){
		SqlSession session = factory.openSession();
		List<MemberVo>  list = session.selectList("member.findAll");
		session.close();
		return list;
	}
	
	
	
}










