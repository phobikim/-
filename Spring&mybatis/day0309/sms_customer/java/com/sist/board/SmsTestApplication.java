package com.sist.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.co.youiwe.webservice.BitSms;

@SpringBootApplication
public class SmsTestApplication {

	public static void main(String[] args) {
		//BitSms sms = new BitSms();
		//sms.sendMsg("01096873487", "01025598279", "안녕?");
		
		SpringApplication.run(SmsTestApplication.class, args);
	}

}
