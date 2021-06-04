package com.sist.board.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.board.db.DBManager;
import com.sist.board.vo.BoardVo;

@Repository
public class BoardDao {
	
	public int totBoard() {
		return DBManager.totBoard();
	}
	
	public int updateBoard(BoardVo b) {
		return DBManager.updateBoard(b);
	}
	
	public int deleteBoard(int no, String pwd) {
		return DBManager.deleteBoard(no, pwd);
	}
	
	public int insertBoard(BoardVo b) {
		return DBManager.insertBoard(b);
	}
	
	public List<BoardVo> listBoard(){
		return DBManager.listBoard();
	}

	public BoardVo getBoard(int no) {
		// TODO Auto-generated method stub
		return DBManager.getBoard(no);
	}
}










