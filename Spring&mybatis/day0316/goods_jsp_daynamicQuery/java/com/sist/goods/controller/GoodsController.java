package com.sist.goods.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

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
	public ModelAndView listGoods(String keyword, String orderFeild, HttpSession session) {		
		System.out.println("keyword:"+keyword);
		System.out.println("orderFeild:"+orderFeild);		
		if(( keyword == null || keyword.equals(""))&& session.getAttribute("keyword")!=null)
		{
			keyword = (String)session.getAttribute("keyword");
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("orderFeild", orderFeild);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll(map));
		
		session.setAttribute("keyword", keyword);
		return mav;
	}
}






