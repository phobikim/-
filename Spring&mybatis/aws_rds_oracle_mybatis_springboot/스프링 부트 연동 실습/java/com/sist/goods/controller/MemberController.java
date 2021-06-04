package com.sist.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sist.goods.dao.MemberDao;

@Controller
public class MemberController {

	@Autowired
	private MemberDao dao;
	
	
	public MemberDao getDao() {
		return dao;
	}


	@RequestMapping("/listMember.do")
	public ModelAndView listMember() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		return mav;
	}
}



