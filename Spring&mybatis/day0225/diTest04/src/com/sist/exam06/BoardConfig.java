package com.sist.exam06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
	
	@Bean
	public BoardDao boardDao()
	{
		return new BoardDao();
	}
}
