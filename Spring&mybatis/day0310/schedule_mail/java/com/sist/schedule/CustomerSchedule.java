package com.sist.schedule;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sist.schedule.dao.CustomerDao;
import com.sist.schedule.vo.Customer;

@Component
@EnableScheduling
public class CustomerSchedule {

	@Autowired
	private CustomerDao dao;
	
	
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}


	@Autowired
	private MailSender javaMailSender;

	public void setJavaMailSender(MailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	//초 분 시간 일 월 요일 연도
	//매월 10일 3시 9분 20초
	@Scheduled(cron = "20 9 15 10 * ?")
	public void sendMail() {
		Date today = new Date();
		int year = today.getYear()+1900;
		int month = today.getMonth();
		
		List<Customer> list = dao.findAll();
		for(Customer c:list) {
			String from = "";
			String to = c.getEmail();
			String name = c.getName();
			int tot = c.getTot();
			String text = name+"님 "+year+"년"+month+"월 요금은"+tot+"원입니다.";
			String subject = name + "님 "+month+"월 명세서입니다.[담당자 : 김은영]";
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setSubject(subject);
			mailMessage.setFrom(from);
			mailMessage.setText(text);
			mailMessage.setTo(to);
			
			try {
				javaMailSender.send(mailMessage);
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
	}
}




