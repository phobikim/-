package com.sist.board.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sist.board.dao.CustomerDao;
import com.sist.board.vo.Customer;

@Controller
public class CustomerController {

	@Autowired
	private CustomerDao dao;
	
	@Autowired
	private MailSender javaMailSender;
	
	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	
	
	
	@RequestMapping("/sendMail.do")
	@ResponseBody
	public String send() {
		
		Date today = new Date();
		int year = today.getYear()+1900;
		int month = today.getMonth();
		
		
		List<Customer> list= dao.findAll();
		for(Customer c:list) {
			String name = c.getName();
			String to = c.getEmail();
			int tot = c.getTot();
			
			String title = name+"님,"+year+"년"+month+"월 명세서입니다.[담당자:김은영]";
			String text= name+"님의 "+year+"년"+month+"월의 요금은 "+ tot + "원입니다.";
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setSubject(title);
			mailMessage.setFrom("");
			mailMessage.setText(text);
			mailMessage.setTo(to);
			try {
				javaMailSender.send(mailMessage);;
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		return "OK";
	}
}






