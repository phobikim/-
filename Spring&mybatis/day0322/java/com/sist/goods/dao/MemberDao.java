package com.sist.goods.dao;

import org.springframework.stereotype.Repository;

import com.sist.goods.db.DBManager;
import com.sist.goods.vo.MemberVo;

@Repository
public class MemberDao {
	
	public MemberVo getMember(String username) {
		return DBManager.getMember(username);
	}

	public int insert(MemberVo m) {
		return DBManager.insertMember(m);
	}
}








