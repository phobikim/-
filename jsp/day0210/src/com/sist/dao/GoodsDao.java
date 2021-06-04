package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.GoodsVo;

import oracle.net.aso.p;

public class GoodsDao {
	private static GoodsDao dao;
	private GoodsDao() {		
	}
	
	public static GoodsDao getInstance()
	{
		if(dao == null) {
			dao = new GoodsDao();
		}
		return dao;
	}
	
	//수정할 상품의 정보를 GoodsVo의 매개변수로 전달받아 해당상품의 정보를 수정하는 메소드 정의
	public int update(GoodsVo g) {
		int re = -1;
		try {
			String sql = "update goods set name=?,qty=?,price=?,fname=? where no=?";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, g.getName());
			pstmt.setInt(2,g.getQty());
			pstmt.setInt(3, g.getPrice());
			pstmt.setString(4, g.getFname());
			pstmt.setInt(5, g.getNo());
			
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
	
	
	
	//상품번호를 매개변수로 전달받아 해당 상품을 삭제하는 메소드를 정의
	public int deleteByNo(int no) {
		int re = -1;
		String sql = "delete goods where no=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd="tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
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
	
	
	
	//상품번호를 매개변수로 전달받아 해당상품의 정보를 데이터베이스 테이블 goods로 부터 검색하여 
	//GoodsVo로 포장하여 반환하는 메소드를 정의
	public GoodsVo findByNo(int no) {
		GoodsVo g = new GoodsVo();
		String sql = "select * from goods where no=?";
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd  = "tiger";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				g.setNo(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setQty(rs.getInt(3));
				g.setPrice(rs.getInt(4));
				g.setFname(rs.getString(5));
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
		
		return g;
	}
	
	
	
	public ArrayList<GoodsVo> findAll(){
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		String sql = "select * from goods";
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn =  DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs =  stmt.executeQuery(sql);
			while(rs.next()) {
				GoodsVo g = new GoodsVo();
				g.setNo(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setQty(rs.getInt(3));
				g.setPrice(rs.getInt(4));
				g.setFname(rs.getString(5));
				list.add(g);
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
	
	
	
	public int insert(GoodsVo g) {
		int re = -1;
		String sql = "insert into goods values(?,?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user,pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setInt(3, g.getQty());
			pstmt.setInt(4, g.getPrice());
			pstmt.setString(5, g.getFname());
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














