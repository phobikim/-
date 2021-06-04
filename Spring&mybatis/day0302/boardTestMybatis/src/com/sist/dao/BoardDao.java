package com.sist.dao;

import java.util.List;

import com.sist.db.BoardManager;
import com.sist.vo.BoardVo;

public class BoardDao {
	public List<BoardVo> findAll(){
		return BoardManager.findAll();
	}
}







