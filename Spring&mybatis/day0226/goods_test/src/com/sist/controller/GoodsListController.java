package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.dao.GoodsDao;
import com.sist.vo.GoodsVo;

@Controller
public class GoodsListController {

	private GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/goodsList.do")
	public ModelAndView insertForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("goodsList");
		mav.addObject("title", "Goods List");
		mav.addObject("list", dao.findAll());
		return mav;
	}

	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.GET)
	public ModelAndView insertGoods() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertGoods");
		return mav;
	}

	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(GoodsVo goods) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertGoods");
		int re = dao.insert(goods);
		if (re == 1) {
			mav.setViewName("redirect:/goodsList.do");
		} else {
			mav.addObject("msg", "상품등록에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
}