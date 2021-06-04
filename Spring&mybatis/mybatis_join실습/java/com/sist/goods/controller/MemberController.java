package com.sist.goods.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sist.goods.dao.MemberDao;

@Controller
public class MemberController {

	@Autowired
	private MemberDao dao;
	
	
	public MemberDao getDao() {
		return dao;
	}


	@RequestMapping("/searchEmp.do")
	public ModelAndView searchEmp(@RequestParam(value = "deptno", defaultValue = "0")  int deptno) {
		ModelAndView mav = new ModelAndView();
		HashMap map = new HashMap();
		if(deptno != 0) {
			map.put("deptno", deptno);
		}
		mav.addObject("list", dao.searchEmp(map));
		return mav;
	}
	
	@RequestMapping("/searchSubordinate.do")
	public ModelAndView searchSubordinate(@RequestParam(value = "empno", defaultValue = "0")  int empno) {
		ModelAndView mav = new ModelAndView();
		HashMap map = new HashMap();
		if(empno != 0) {
			map.put("empno", empno);
		}
		mav.addObject("list", dao.searchSubordinate(map));
		return mav;
	}
}




