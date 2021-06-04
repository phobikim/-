package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.BoardDao;

@Controller
public class BoardController {

	private BoardDao dao;
	
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/listBoard.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();	
		mav.addObject("list", dao.findAll());
		return mav;
	}
}








