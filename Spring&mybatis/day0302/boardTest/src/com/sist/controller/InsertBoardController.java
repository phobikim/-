package com.sist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.BoardDao;
import com.sist.vo.BoardVo;

@Controller
public class InsertBoardController {
	private BoardDao dao;
	

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}


	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertBoard");
		return mav;
	}
	
	
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public ModelAndView submit(BoardVo b, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		b.setIp(request.getRemoteAddr());
		int re =dao.insertBoard(b);
		if(re == 1) {
			mav.setViewName("redirect:/listBoard.do");
		}else {
			mav.addObject("msg", "게시물 등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
}





