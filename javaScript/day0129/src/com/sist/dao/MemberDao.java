package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public ArrayList<MemberVo> selectAll(){
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		String sql = "select * from member";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			if(rs != null)
			{
				rs.close();
			}
			
			if(stmt != null) {
				stmt.close();
			}
			
			if(conn != null) {
				conn.close();
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:"+ e.getMessage());
		}
		return list;
	}
}


















