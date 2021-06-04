package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVo;

@Repository
public class GoodsDao {
	public List<GoodsVo> findAll(){
		System.out.println("dao동작함");
		return DBManager.findAll();
	}

	public int insertGoods(GoodsVo g) {
		// TODO Auto-generated method stub
		return DBManager.insert(g);
	}

	public GoodsVo selectGoods(int no) {
		// TODO Auto-generated method stub
		return DBManager.selectGoods(no);
	}

	public int deleteGoods(int no) {
		// TODO Auto-generated method stub
		return DBManager.deleteGoods(no);
	}

	public int updateGoods(GoodsVo g) {
		// TODO Auto-generated method stub
		return DBManager.updateGoods(g);
	}
}












