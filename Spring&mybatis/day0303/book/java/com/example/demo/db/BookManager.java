package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BookVo;

public class BookManager {
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/example/demo/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static BookVo selectBook( int no  ) {
		SqlSession session = factory.openSession();
		BookVo b = session.selectOne("book.selectBook", no);
		session.close();
		return b;
	}
	
	
	public static List<BookVo> findAll(){
		SqlSession session = factory.openSession();
		List<BookVo> list = session.selectList("book.findAll");
		session.close();
		return list;
	}
	
	
}
















