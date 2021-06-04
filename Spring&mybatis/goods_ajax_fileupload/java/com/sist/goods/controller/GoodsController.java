package com.sist.goods.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sist.goods.dao.GoodsDao;
import com.sist.goods.vo.GoodsVo;

@RestController
public class GoodsController {
	
	@Autowired
	private GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/insertGoods.do")
	public String insertGoods(GoodsVo g) {
		System.out.println(g);
		return "OK";
	}
	
	
	@RequestMapping("/listGoods.do")
	public String listGoods() {
		int total = dao.getTotalRecord();
		Gson gson = new Gson();
		return  gson.toJson(dao.findAll(1, total));
	}
	
}	
