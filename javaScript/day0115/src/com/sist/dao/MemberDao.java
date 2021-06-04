package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sist.vo.MemberVo;

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
	
	
	public int insertMember(MemberVo m) {
		String sql = "insert into member values(?,?,?,?)";
		int re = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getPwd());
			pstmt.setString(4, m.getEmail());
			
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return re;
	}
}
