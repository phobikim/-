package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BookDao;

@Controller
public class BookController {
	
	@Autowired
	private BookDao dao;
	
	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listBook.do")
	public ModelAndView listBook() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		return mav;
	}
	
	@RequestMapping("/detailBook.do")
	public ModelAndView detailBook(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("b",dao.selectBook(no));
		return mav;
	}
}	











