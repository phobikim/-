package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BoardVo;

public class BoardDao {
	
	
	//���ο� �Խù� ��ȣ�� �����Ͽ� ��ȯ�ϴ� �޼ҵ鸣 ����
	//select max(no)+1 from board
	public int createNo() {
		
		int no = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd= "tiger";
			String sql = "select max(no)+1 from board";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				no = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		return no;
	}
	
	
	// ��� ���ڵ带 �˻��Ͽ� ��ȯ�ϴ� �޼ҵ带 ����
	// select * from board
	public ArrayList<BoardVo> arrRecord(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		try {
			String sql = "select * from board";
			
			//1. jdbc ����̹��� �޸𸮷� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db ������ �����Ѵ�.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			
			
			//3. Statement��ü�� �����Ѵ�.
			Statement stmt = conn.createStatement();
			
			//4. sql����� �����Ѵ�.
			ResultSet rs = stmt.executeQuery(sql);
			
			//rs�� ��� �� ��ŭ list�� ��� �ݴϴ�.
			while(rs.next()) {
				BoardVo b = new BoardVo();
				b.setNo(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setPwd(rs.getString(3));
				b.setEmail(rs.getString(4));
				b.setTitle(rs.getString(5));
				b.setContent(rs.getString(6));
				b.setFname(rs.getString(7));
				list.add(b);
			}
				
			
			//5. ����ߴ� �ڿ����� �ݾ� �ݴϴ�.
			rs.close();
			stmt.close();
			conn.close();
			
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		return list;
	}
	
	
	
	
	
	
	//insert�� ���ؼ���
	//Statement Ŭ������ executeUpdate�޼ҵ带 ����մϴ�.
	//�̸޼ҵ�� ���������� sql�� ������ ���ڵ��� ���� ��ȯ�մϴ�.
	//�츮�� �������θ� int�� ��ȯ�ϱ�� �ؿ�!
	public int insertBoard( BoardVo b ) {
		int re = -1;
		try {
			String sql = "insert into board values(?,?,?,?,?,?,?)";
			
			//1. jdbc ����̹��� �޸𸮷� �ε��Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db Server�� �����Ѵ�.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			
			//3. sql�� ������ ���� Statement(PreparedStatement)��ü�� �����Ѵ�.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ������ ?�� ���� �����Ѵ�.
			int no = createNo();
			pstmt.setInt(1, no);
			pstmt.setString(2, b.getName());
			pstmt.setString(3, b.getPwd());
			pstmt.setString(4, b.getEmail());
			pstmt.setString(5, b.getTitle());
			pstmt.setString(6, b.getContent());
			pstmt.setString(7, b.getFname());
			
			
			//5. sql����� �����Ų��.
			//      executeUpdate   ==> �����ͺ��̽��� ������ �ִ� ���(insert, update, delete)
			//						==> int�� ��ȯ(���������� ����� ������ ���� �� )
			
			
			//      executeQuery	==> �����ͺ��̽��� ��ȸ ���  (select)
			//						==> �˻��� �����  ResultSet���� ��ȯ
			re = pstmt.executeUpdate(); 
			
			
			//6. ����ߴ� �ڿ��� �ݾ� �ݴϴ�.
			pstmt.close();
			conn.close();
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		return re;
	}
}














