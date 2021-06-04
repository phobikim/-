package com.sist.exam07;

public class SystemMonitor {
	private long periodTime;
	private SmsSender sender;
	public SystemMonitor(long periodTime, SmsSender sender) {
		super();
		this.periodTime = periodTime;
		this.sender = sender;
	}
	public void execute() {
		System.out.println(periodTime + "분 간격으로");
		sender.send();
	}
}
