package com.sist.goods.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.goods.db.dao.GoodsDao;

@Controller
public class GoodsController {

	@Autowired
	private GoodsDao dao;
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listGoods.do")
	public ModelAndView listGoods(String keyword) {		
		System.out.println("keyword:"+keyword);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll(map));
		return mav;
	}
}






