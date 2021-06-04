package com.sist.goods.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.goods.vo.GoodsVo;



public class GoodsManager {
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
	
	
	public static List<GoodsVo> findAll(HashMap<String, Object> map){
		SqlSession session = factory.openSession();
		List<GoodsVo>  list = session.selectList("goods.findAll",map);
		session.close();
		return list;
	}
	
}










