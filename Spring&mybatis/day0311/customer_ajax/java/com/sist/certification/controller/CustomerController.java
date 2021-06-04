package com.sist.certification.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sist.certification.dao.CustomerDao;
import com.sist.certification.vo.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerDao dao;
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/deleteCustomer.do")
	public String deleteCustomer(int no) {
		String r = "ok";
		int re = dao.delete(no);
		if(re != 1) {
			r = "no";
		}
		return r;
	}
	
	@RequestMapping("/updateCustomer.do")
	public String updateCustomer(Customer c) {
		String r = "ok";
		int re = dao.update(c);
		if(re != 1) {
			r = "no";
		}
		return r;
	}
	
	
	
	@RequestMapping("/insertCustomer.do")

	public String insertCustomer(Customer c) {
		String r = "ok";
		int re = dao.insert(c);
		if(re != 1) {
			r = "no";
		}
		return r;
	}
	
	
	
	@RequestMapping("/listCustomer.do")
	public String listCustomer() {
		String r = "";
		List<Customer> list = dao.findAll();
		Gson gson = new Gson();
		r = gson.toJson(list);
		return r;
	}
}





