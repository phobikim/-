package com.sist.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BoardVo;

public class BoardDao {
	private static BoardDao dao;
	private BoardDao() {
		
	}
	
	public static BoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDao();
		}
		return dao;
	}
	
	//수정할 게시물의 정보를 BoardVo로 전달받아 해당 게시물의 정보를 수정하는 메소드를 정의
	public int update(BoardVo b) {
		String sql = "update board set writer=?,title=?,content=?,"
				+ "fname=?,fsize=? where no=? and pwd=?";
		
		int re = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getFname());
			pstmt.setInt(5, b.getFsize());
			pstmt.setInt(6, b.getNo());
			pstmt.setString(7, b.getPwd());
			re = pstmt.executeUpdate();
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	
	
	
	// 글번호를 매개변수로 전달받아 조회수를 증가하는 메소드를 정의
	public void updateHit(int no) {
		String sql = "update board set hit=hit+1 where no=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}		
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
		
	
	//게시물 번호를 매개변수로 전달받아 해당게시물을 검색하여 BoardVo로 반환하는 메소드를 정의
	//getBoard메소드는 게시물 상세보기에서 호출이 될 것입니다.
	//또, 게시물 수정하기 에서도 원래 게시물의 정보를 읽어와서 
	//수정을 위한 form양식에 원래 게시물의 내용을 출력 할 때에에 필요할 거에요. 
	//상세보기에서 getBoard를 호출할때에는 조회수를 증가하기 위하여 true를 전달할 것이고
	//수정하기에서 getBoard를 호출할때에는 조회수를 증가하면 안되니 false를 절달 할 것입니다.
	
	public BoardVo getBoard(int no, boolean isUpdate) {
		
		if(isUpdate) {
			updateHit(no);
		}
		
		BoardVo b = new BoardVo();
		String sql = "select * from board where no=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				b.setNo(rs.getInt(1));
				b.setWriter(rs.getString(2));
				b.setPwd(rs.getString(3));
				b.setTitle(rs.getString(4));
				b.setContent(rs.getString(5));
				b.setIp(rs.getString(6));
				b.setRegdate(rs.getTimestamp(7));
				b.setHit(rs.getInt(8));
				b.setFname(rs.getString(9));
				b.setFsize(rs.getInt(10));
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return b;
	}
	
	
	
	//모든 게시물 목록을 반환하는 메소드를 정의
	//select * from board
	public ArrayList<BoardVo> findAll(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		String sql = "select * from board";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd ="tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs  = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVo b = new BoardVo();
				b.setNo(rs.getInt(1));
				b.setWriter(rs.getString(2));
				b.setPwd(rs.getString(3));
				b.setTitle(rs.getString(4));
				b.setContent(rs.getString(5));
				b.setIp(rs.getString(6));
				b.setRegdate(rs.getTimestamp(7));
				b.setHit(rs.getInt(8));
				b.setFname(rs.getString(9));
				b.setFsize(rs.getInt(10));
				list.add(b);
			}
			
			if(rs != null) {
				rs.close();
			}
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return list;
	}
	
	
	public int insert(BoardVo b) {
		System.out.println(b);
		
		int re = -1;
		String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,"
				+ "sysdate,0,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url ="jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getPwd());
			pstmt.setString(3, b.getTitle());
			pstmt.setString(4, b.getContent());
			pstmt.setString(5, b.getIp());
			pstmt.setString(6, b.getFname());
			pstmt.setInt(7, b.getFsize());
			
			re =pstmt.executeUpdate();
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return re;
	}
}


























