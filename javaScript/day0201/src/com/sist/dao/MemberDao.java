package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.MemberVO;

public class MemberDao {
	private static MemberDao dao;
	private MemberDao() {		
	}
	
	public static MemberDao getInstance() {
		
		if(dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}
	
	public int deleteMember(String id) {
		int re = -1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "delete member where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			re=pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public int updateMember(MemberVO m) {
		int re =  -1;
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "update member set email=? where id=? and pwd=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getId());
			pstmt.setString(3, m.getPwd());
			
			re =pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	
	public int insertMember(MemberVO m) {
		int re = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into member values(?,?,?,?)";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getPwd());
			pstmt.setString(4, m.getEmail());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	
	public ArrayList<MemberVO> findAll(){
		String sql = "select * from member";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		Statement stmt  = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new MemberVO(rs.getString(1), rs.getString(2),	rs.getString(3), rs.getString(4)));
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
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
				// TODO: handle exception
			}
		}
		
		return list;
		
	}
	
	
	
	
}








