package com.sist.goods.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sist.goods.db.DBManager;
import com.sist.goods.vo.SearchEmp;

@Repository
public class MemberDao {
	
	public List<SearchEmp> searchEmp(HashMap map){
		return DBManager.seachEmp(map);
	}
	
	public List<Map> searchSubordinate(HashMap map){
		return DBManager.searchSubordinate(map);
	}
}



