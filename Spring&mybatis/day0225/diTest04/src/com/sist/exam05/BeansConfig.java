package com.sist.exam05;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}
		
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean(autowire = Autowire.BY_TYPE)
	public SistSystem system() {
		SistSystem system= new SistSystem();
		//system.setBoardDao(boardDao());
		//system.setMemberDao(memberDao());
		return system;
	}
}





