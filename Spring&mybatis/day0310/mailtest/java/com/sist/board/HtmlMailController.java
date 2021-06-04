package com.sist.board;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HtmlMailController {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}



	@RequestMapping("/htmlMail.do")
	@ResponseBody
	public String send() {
		javaMailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				// TODO Auto-generated method stub
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				message.setFrom("");
				message.setTo("rola70@nate.com");
				message.setSubject("html 메일 보내기 연습");
				String text = "<h2>회원가입 성공!</h2><hr>";
				text += "<img src='cid:ball'>";
				message.setText(text, true);
				message.addInline("ball", new ClassPathResource("img/ball1.jpg"));
				message.addAttachment("hello.txt", new ClassPathResource("doc/hello.txt"));
			}
		});
		
		return "OK";
	}
}
