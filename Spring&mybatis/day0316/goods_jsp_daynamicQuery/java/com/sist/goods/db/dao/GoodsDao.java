package com.sist.goods.db.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.goods.db.GoodsManager;
import com.sist.goods.vo.GoodsVo;


@Repository
public class GoodsDao {
	public List<GoodsVo> findAll(HashMap<String, Object> map){
		return GoodsManager.findAll(map);
	}
}








