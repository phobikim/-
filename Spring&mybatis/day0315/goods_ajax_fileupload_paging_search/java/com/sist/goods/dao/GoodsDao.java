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
	
	
	public int getTotalRecord(String keyword, String searchFeild, String op) {
		return DBManager.getTotalRecord(keyword,searchFeild,op);
	}
	
	public List<GoodsVo> findAll(int start, int end, String keyword, String searchFeild, String op, String orderFeild){
		System.out.println("dao동작함");
		return DBManager.findAll(start, end,keyword,searchFeild,op,orderFeild);
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












