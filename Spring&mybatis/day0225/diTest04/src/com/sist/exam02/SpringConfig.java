package com.sist.exam02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean
	public UpdateInfo info() {
		UpdateInfo info = new UpdateInfo();
		info.setId("tiger");
		return info;
	}
	
	@Bean
	public MemberService ms() {
		MemberService ms = new MemberService();
		ms.setInfo(info());
		return ms;
	}
}











