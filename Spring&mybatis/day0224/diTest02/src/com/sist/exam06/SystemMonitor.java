package com.sist.exam06;

public class SystemMonitor {
	private int periodTime;

	public SystemMonitor(int periodTime) {
		super();
		this.periodTime = periodTime;
	}
	
	public void execute() {
		System.out.println(periodTime+"분 간격으로 모니터링 합니다.");		
	}
}
