package com.sist.exam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean
	public MemberService member1(){
		return new MemberService();
	}
	
}
