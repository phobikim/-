package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.ScheduleVo;

public class ScheduleDao {
	private static ScheduleDao dao;
	private ScheduleDao() {
		
	}
	
	public static ScheduleDao getInstance() {
		if(dao == null) {
			dao = new ScheduleDao();
		}
		return dao;
	}
	
	public ArrayList<ScheduleVo> findAll(){
		ArrayList<ScheduleVo> list = new ArrayList<ScheduleVo>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from schedule");
			while(rs.next()) {
				list.add(new ScheduleVo(rs.getInt(1), rs.getString(2), rs.getString(3)));
				
			}
			ConnectionProvider.close(conn, stmt, rs);
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return list;
	}
	
	
	public int insert(ScheduleVo s) {
		int re = -1;
		String sql = "insert into schedule values(seq_schedule.nextval,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getEvent_name());
			pstmt.setString(2,s.getEvent_date());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
					
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		
		return re;
	}
}





















