package com.sist.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	
	public int updateBook(BookVo b) {
		System.out.println("도서수정");
		System.out.println(b);
		
		int re = -1;
		String sql = "update book set name=?,publisher=?,price=? where no=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url,user,pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getName());
			pstmt.setString(2, b.getPublisher());
			pstmt.setInt(3, b.getPrice());
			pstmt.setInt(4, b.getNo());
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
	
	
	public int deleteBook(int no) {
		int re = -1;
		try {
			String sql = "delete book where no=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url,user,pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
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
	
	
	public BookVo getBook(int no) {
		String sql = "select * from book where no=?";
		BookVo b = new BookVo();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url,user,pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				b.setNo(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPublisher(rs.getString(3));
				b.setPrice(rs.getInt(4));
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
	
	
	public int insert(BookVo b) {
		int re = -1;
		String sql = "insert into book values(?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url,user,pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getName());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			re = pstmt.executeUpdate();
			
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+ e.getMessage());
		}
		return re;
	}
	
	
	public ArrayList<BookVo> findAll(){
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String sql = "select * from book";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url,user,pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BookVo b = new BookVo();
				b.setNo(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPublisher(rs.getString(3));
				b.setPrice(rs.getInt(4));
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
}









