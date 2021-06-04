package com.sist.vo;

public class ScheduleVo {
	private int no;
	private String event_name;
	private String event_date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_date() {
		return event_date;
	}
	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}
	public ScheduleVo(int no, String event_name, String event_date) {
		super();
		this.no = no;
		this.event_name = event_name;
		this.event_date = event_date;
	}
	@Override
	public String toString() {
		return "ScheduleVo [no=" + no + ", event_name=" + event_name + ", event_date=" + event_date + "]";
	}
	public ScheduleVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
