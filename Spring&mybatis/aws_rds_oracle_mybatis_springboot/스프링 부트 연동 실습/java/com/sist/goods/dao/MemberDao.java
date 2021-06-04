package com.sist.goods.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.goods.db.DBManager;
import com.sist.goods.vo.MemberVo;

@Repository
public class MemberDao {

	public List<MemberVo> findAll(){
		return DBManager.findAll();
	}
}
