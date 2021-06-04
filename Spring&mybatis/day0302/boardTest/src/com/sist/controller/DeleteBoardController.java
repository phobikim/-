package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.BoardDao;

@Controller
public class DeleteBoardController {

	private BoardDao dao;
	
	
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/deleteBoard.do", method = RequestMethod.GET)
	public ModelAndView form(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", no);
		mav.setViewName("deleteBoard");
		return mav;
	}
	
	@RequestMapping(value = "/deleteBoard.do", method = RequestMethod.POST)
	public ModelAndView submit(int no, String pwd) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		int re = dao.deleteBoard(no, pwd);
		if(re !=1) {
			mav.addObject("msg", "게시물 삭제에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
}







