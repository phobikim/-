package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sist.vo.BoardVo;

import oracle.net.aso.p;

public class BoardDao {
	private static BoardDao dao ;
	private BoardDao() {
		
	}
	
	public static BoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDao();
		}
		return dao;
	}
	
	public int insert(BoardVo b) {
		int re = -1;
		String sql = "insert into board values(seq_board.nextval,?,?,?,?,?,sysdate,0,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
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
	
}












