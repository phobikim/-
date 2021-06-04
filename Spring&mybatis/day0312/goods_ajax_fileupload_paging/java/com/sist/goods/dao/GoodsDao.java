package com.sist.goods.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sist.goods.db.DBManager;
import com.sist.goods.vo.GoodsVo;



@Repository
public class GoodsDao {
	
	public int getDiv(int a, int b) {
		int r = a/b;
		return r;
	}
	
	
	public int getTotalRecord() {
		return DBManager.getTotalRecord();
	}
	
	public List<GoodsVo> findAll(int start, int end){
		System.out.println("dao동작함");
		return DBManager.findAll(start, end);
	}

	public int insertGoods(GoodsVo g) {
		// TODO Auto-generated method stub
		return DBManager.insert(g);
	}

	public GoodsVo selectGoods(int no) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
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












