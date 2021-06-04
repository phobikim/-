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
	
	
	public static MemberVo getMember(String username) {
		SqlSession session  = factory.openSession();
		MemberVo m = session.selectOne("member.getMember", username);
		System.out.println("회원정보:"+m);
		session.close();
		return m;
	}
	
	
	public static int insertMember(MemberVo m) {
		SqlSession session = factory.openSession();
		int re = session.insert("member.insert", m);
		session.commit();
		session.close();
		return re;
	}
	
	
	
}










