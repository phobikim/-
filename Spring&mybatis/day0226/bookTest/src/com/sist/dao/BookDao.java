package com.sist.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVo;

public class BookDao {
	
	public ArrayList<BookVo> findAll(){
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String sql = "select * from book";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd="tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BookVo(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4)));
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














