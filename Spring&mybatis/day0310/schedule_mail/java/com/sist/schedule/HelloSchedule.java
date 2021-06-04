package com.sist.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class HelloSchedule {
	
	//@Scheduled(fixedRate = 10000)
	@Scheduled(cron = "0 45 12 * * ?")
	public void pro() {
		System.out.println("콜콜!");
	}
}
