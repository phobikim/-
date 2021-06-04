package com.sist.board.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.board.vo.BoardVo;

public class DBManager {
	
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("com/sist/board/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	public static int totBoard() {
		SqlSession session = factory.openSession();
		int total = session.selectOne("board.totBoard");
		session.close();
		return total;
	}
	
	
	public static int updateBoard(BoardVo b) {
		SqlSession session = factory.openSession();
		int re= session.update("board.update", b);
		session.commit();
		session.close();
		return re;
	}
	
	public static int deleteBoard(int no, String pwd) {
		SqlSession session = factory.openSession();
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("no", no);
		map.put("pwd",pwd);
		int re = session.delete("board.delete", map);
		session.commit();
		session.close();
		return re;
	}
	
	
	public static int insertBoard(BoardVo b) {
		SqlSession session = factory.openSession();
		int re = session.insert("board.insert",b);
		session.commit();
		session.close();
		return re;
	}
	
	
	public static List<BoardVo> listBoard(){
		SqlSession session = factory.openSession();
		List<BoardVo> list= session.selectList("board.findAll");
		session.close();
		return list;
	}


	public static BoardVo getBoard(int no) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		BoardVo b = session.selectOne("board.getBoard",no);
		session.close();
		return b;
	}
	
}














