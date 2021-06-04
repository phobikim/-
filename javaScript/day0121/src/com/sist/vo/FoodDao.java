package com.sist.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodDao {
	private static FoodDao dao ;
	private FoodDao() {
	}
	
	public static FoodDao getInstance() {
		if(dao == null) {
			dao = new FoodDao();
		}
		return dao;
	}
	
	
	public ArrayList<FoodVo> selectAll(){
		String sql = "select * from food";
		ArrayList<FoodVo> list = new ArrayList<FoodVo>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new FoodVo(rs.getInt(1), rs.getString(2)));
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
			System.out.println(e.getMessage());
		}
		return list;
	}
}





