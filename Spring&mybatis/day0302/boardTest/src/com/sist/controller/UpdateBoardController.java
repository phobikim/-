package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.BoardDao;
import com.sist.vo.BoardVo;

@Controller
public class UpdateBoardController {

	private BoardDao dao;
	
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value ="/updateBoard.do", method = RequestMethod.GET)
	public ModelAndView form(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.getBoard(no));
		mav.setViewName("updateBoard");
		return mav;
	}
	
	@RequestMapping(value = "/updateBoard.do",method = RequestMethod.POST)
	public ModelAndView submit(BoardVo b) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		int re = dao.updateBoard(b);
		if(re != 1) {
			mav.addObject("msg", "게시물 수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
}










