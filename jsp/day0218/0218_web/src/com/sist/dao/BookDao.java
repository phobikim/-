package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.sist.vo.BookVo;

import oracle.net.aso.p;

public class BookDao {
	private static BookDao dao;
	private BookDao() {
		
	}
	
	public static BookDao getInstance() {
		if(dao == null) {
			dao = new BookDao();
		}
		return dao;
	}
	
	public int insert(BookVo b) {
		int re = -1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			String sql = "insert into book values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getName());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			re = pstmt.executeUpdate();
			
			if( pstmt != null) {
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












