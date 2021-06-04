package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDao;

@Controller
public class GoodsController {

	@Autowired
	private GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listGoods.do")
	public ModelAndView listGoods() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		return mav;
	}
	
}






