package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BoardVo;

public class BoardDao {
	
	public int deleteBoard(int no, String pwd) {
		int re = -1;
		try {
			String sql = "delete board where no=? and pwd=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			pstmt.setString(2, pwd);
			
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
	public int updateBoard(BoardVo b) {
		int re = -1;
		try {
			String sql = "update board set title=?,content=? where no=? and pwd=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNo());
			pstmt.setString(4, b.getPwd());
			
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
	public int insertBoard(BoardVo b) {
		int re = -1;
		try {
			String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,sysdate,0,null,null)";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getPwd());
			pstmt.setString(3, b.getTitle());
			pstmt.setString(4, b.getContent());
			pstmt.setString(5, b.getIp());
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
	
	
	public BoardVo getBoard(int no) {
		BoardVo b = new BoardVo();
		String sql = "select * from board where no=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
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
	
	
	
	public ArrayList<BoardVo> findAll(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		try {
			String sql = "select * from board";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
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
		
		System.out.println("데이터수:"+list.size());
		return list;
	}
}
