package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.BoardDao;

@Controller
public class DetailBoardController {
	private BoardDao dao;
	
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}


	@RequestMapping("/detailBoard.do")
	public ModelAndView detail(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.getBoard(no));
		mav.setViewName("detailBoard");
		return mav;
	}
}












