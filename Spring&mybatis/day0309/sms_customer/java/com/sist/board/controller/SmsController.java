package com.sist.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.board.dao.CustomerDao;
import com.sist.board.vo.Customer;

import kr.co.youiwe.webservice.BitSms;

@Controller
public class SmsController {
	
	@Autowired
	private CustomerDao dao;
		
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/sms.do")
	@ResponseBody
	public String smsSend() {
		
		List<Customer> list = dao.findAll();
		String from= "01086469577";
		BitSms sms = new BitSms();
		for(Customer c:list) {
			String to = c.getPhone();
			String name = c.getName();
			int total = c.getTot();
			String msg = name + "님,이번달 요금은 " + total + "입니다. [담당자:김은영]";
			sms.sendMsg(from, to, msg);
		}
		
		return "OK";
	}
}





