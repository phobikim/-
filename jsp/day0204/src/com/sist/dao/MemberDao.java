package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sist.db.ConnectionProvider;
import com.sist.vo.MemberVo;

public class MemberDao {
	//아이디와 암호를 매개변수로 전달받아 
	//올바른 회원이면 true, 그렇지 않으면 false를 반환하는 메소드를 정의하세요
	
	private static MemberDao dao;
	private MemberDao() {	}
	
	public static MemberDao getInstance() {
		if(dao ==  null) {
			dao = new MemberDao();
		}
		return dao;
	}
	
	public int insert(MemberVo m) {
		int re = -1;
		try {
			String sql = "insert into member values(?,?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
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
	
	
	public boolean isMember(String id, String pwd) {
		boolean re = false;
		try {			
			String sql = "select * from member where id=? and pwd=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				re = true;
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return re;
	}
}




























