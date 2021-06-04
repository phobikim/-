package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVo;

public class BookDao {
	private static BookDao dao;
	private BookDao() {}
	public static BookDao getInstance() {
		if(dao == null) {
			dao = new BookDao();
		}
		return dao;
	}
	
	public int deleteBook(int no) {
		int re = -1;
		String sql = "delete book where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return re;
	}
	
	
	
	public int updateBook(BookVo b) {
		int re = -1;
		String sql = "update book set name=?,publisher=?,price=? where no=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getName());
			pstmt.setString(2, b.getPublisher());
			pstmt.setInt(3, b.getPrice());
			pstmt.setInt(4,b.getNo());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return re;
	}
	
	public int insertBook(BookVo b) {
		int re = -1;
		String sql = "insert into book values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getName());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());

			re = pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		return re;
	}
	
	
	
	public ArrayList<BookVo> selectAll(){
		String sql = "select * from book";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BookVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}	
			
		}catch (Exception e) {
			System.out.println("예외발생:"+ e.getMessage());
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


















