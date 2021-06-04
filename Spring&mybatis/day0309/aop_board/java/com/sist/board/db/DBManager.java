package com.sist.board.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.board.vo.BoardVo;
import com.sist.board.vo.Sist_log;

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
	
	public static void insertLog(Sist_log log) {
		SqlSession session = factory.openSession(true);
		session.insert("sist_log.insert", log);
		session.close();
	}
	
	
	
	public static void updateStep(int b_ref, int b_step) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("b_ref", b_ref);
		map.put("b_step", b_step);
		SqlSession session = factory.openSession();
		session.update("board.updateStep", map);
		session.commit();
		session.close();
	}
	
	public static int getNextNo() {
		SqlSession session = factory.openSession();
		int no =session.selectOne("board.nextNo");
		session.close();
		return no;
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
		System.out.println("---------manager-----------");
		System.out.println("b_ref:"+b.getB_ref());
		System.out.println("b_step:"+b.getB_step());
		System.out.println("b_level:"+b.getB_level());
		System.out.println("------------------------");
		int re = session.insert("board.insert",b);
		session.commit();
		session.close();
		return re;
	}
	
	
	public static List<BoardVo> listBoard(int start, int end){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		SqlSession session = factory.openSession();
		List<BoardVo> list= session.selectList("board.findAll",map);
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














