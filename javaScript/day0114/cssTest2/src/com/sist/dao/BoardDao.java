package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BoardVo;

public class BoardDao {
	
	
	//새로운 게시물 번호를 생성하여 반환하는 메소들르 정의
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
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return no;
	}
	
	
	// 모든 레코드를 검색하여 반환하는 메소드를 정의
	// select * from board
	public ArrayList<BoardVo> arrRecord(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		try {
			String sql = "select * from board";
			
			//1. jdbc 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db 서버에 연결한다.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			
			
			//3. Statement객체를 생성한다.
			Statement stmt = conn.createStatement();
			
			//4. sql명령을 실행한다.
			ResultSet rs = stmt.executeQuery(sql);
			
			//rs에 담긴 수 만큼 list에 담아 줍니다.
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
				
			
			//5. 사용했던 자원들을 닫아 줍니다.
			rs.close();
			stmt.close();
			conn.close();
			
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return list;
	}
	
	
	
	
	
	
	//insert를 위해서는
	//Statement 클래스의 executeUpdate메소드를 사용합니다.
	//이메소드는 성공적으로 sql을 실행한 레코드의 수를 반환합니다.
	//우리도 성공여부를 int로 반환하기로 해요!
	public int insertBoard( BoardVo b ) {
		int re = -1;
		try {
			String sql = "insert into board values(?,?,?,?,?,?,?)";
			
			//1. jdbc 드라이버를 메모리로 로드한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. db Server에 연결한다.
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "scott";
			String pwd = "tiger";
			Connection conn = DriverManager.getConnection(url, user, pwd);
			
			//3. sql을 실행을 위한 Statement(PreparedStatement)객체를 생성한다.
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 각각의 ?에 값을 설정한다.
			int no = createNo();
			pstmt.setInt(1, no);
			pstmt.setString(2, b.getName());
			pstmt.setString(3, b.getPwd());
			pstmt.setString(4, b.getEmail());
			pstmt.setString(5, b.getTitle());
			pstmt.setString(6, b.getContent());
			pstmt.setString(7, b.getFname());
			
			
			//5. sql명령을 실행시킨다.
			//      executeUpdate   ==> 데이터베이스에 변동이 있는 명령(insert, update, delete)
			//						==> int를 반환(성공적으로 명령을 수행한 행의 수 )
			
			
			//      executeQuery	==> 데이터베이스에 조회 명령  (select)
			//						==> 검색한 결과를  ResultSet으로 반환
			re = pstmt.executeUpdate(); 
			
			
			//6. 사용했던 자원을 닫아 줍니다.
			pstmt.close();
			conn.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
}














