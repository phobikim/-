package com.sist.certification.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.certification.dao.CustomerDao;
import com.sist.certification.vo.Customer;

@Controller
public class JoinController {
	
	Random random  = new Random();
	
	@Autowired
	private CustomerDao dao;
	
	
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping("/sendCode.do")
	@ResponseBody
	public String   sendCode(String type, String to)
	{
		System.out.println("type:"+type);
		System.out.println("to:"+to);
		
		int a = random.nextInt(10);
		int b = random.nextInt(10);
		int c = random.nextInt(10);
		int d = random.nextInt(10);
		String code = a+""+b+""+c+""+d;
		return code;				
	}
	
	

	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public void joinForm() {
		
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	@ResponseBody
	public String joinSubmit(Customer c) {
		int re = dao.insert(c);
		String result = "회원가입에 성공하였습니다.";
		if(re != 1) {
			result = "회원가입이 실패하였습니다.";
		}
		return result;
	}
}
