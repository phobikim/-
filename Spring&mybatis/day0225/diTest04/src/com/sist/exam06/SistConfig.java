package com.sist.exam06;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BoardConfig.class, MemberConfig.class})
public class SistConfig {
	
	@Bean(autowire = Autowire.BY_TYPE)
	public SistSystem system() {
		SistSystem system = new SistSystem();
		return system;
	}
}
