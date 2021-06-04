package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
	public int insert(MemberVo m) {
		int re = -1;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = 
					DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPasswd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getPhone1());
			pstmt.setString(5, m.getPhone2());
			pstmt.setString(6, m.getPhone3());
			pstmt.setString(7, m.getSex());
			pstmt.setString(8, m.getBloodtype());
			pstmt.setString(9, m.getHobby());
			pstmt.setString(10, m.getCity());
			pstmt.setString(11, m.getInfo());
			
			re = pstmt.executeUpdate();
			// executeUpate는 성공적으로 sql를 실행한 레코드의 수를 반환
			// 그값을 가지고 sql을 성공했는지 실패했는지 판단 할 수있어요.
			
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
	
	
	// 매개변수로 id를 전달받아 해당아이디가 이미 member테이블에 있는지 판별하여
	// 아이디가 이미 있으면 ==> true  
	// 아이디가 없으면 ==> false
	public boolean  isAlreadyId(String id) {
		boolean re = false;
		String sql = "select * from member where id=?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", 
							"scott", "tiger");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				re = true;
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
		return re;
	}
}










