package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.GoodsVo;

public class GoodsDao {
	/*
	 * default 값이 singleton이기 때문에 singleton pattern을 만들 필요 없음 private static
	 * GoodsDao dao;
	 * 
	 * private GoodsDao() { }
	 * 
	 * public static GoodsDao getInstance() { if (dao == null) dao = new GoodsDao();
	 * return dao; }
	 */

	public int insert(GoodsVo goods) {
		int re = -1;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			String sql = " insert into goods values(?,?,?,?,?)";
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, goods.getNo());
			pstmt.setString(2, goods.getName());
			pstmt.setInt(3, goods.getQty());
			pstmt.setInt(4, goods.getPrice());
			pstmt.setString(5, goods.getFname());
			re = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return re;
	}

	public ArrayList<GoodsVo> findAll() {
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from goods";
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String password = "tiger";
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new GoodsVo(rs.getInt("no"), rs.getString("name"), rs.getInt("qty"), rs.getInt("price"),
						rs.getString("fname")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
