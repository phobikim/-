package com.sist.vo;

import java.sql.Timestamp;

public class BoardVo {
	private int no;
	private String writer;
	private String pwd;
	private String title;
	private String content;
	private String ip;
	private Timestamp regdate;
	private int hit;
	private String fname;
	private int fsize;
	public BoardVo(int no, String writer, String pwd, String title, String content, String ip, Timestamp regdate,
			int hit, String fname, int fsize) {
		super();
		this.no = no;
		this.writer = writer;
		this.pwd = pwd;
		this.title = title;
		this.content = content;
		this.ip = ip;
		this.regdate = regdate;
		this.hit = hit;
		this.fname = fname;
		this.fsize = fsize;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getFsize() {
		return fsize;
	}
	public void setFsize(int fsize) {
		this.fsize = fsize;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", writer=" + writer + ", pwd=" + pwd + ", title=" + title + ", content=" + content
				+ ", ip=" + ip + ", regdate=" + regdate + ", hit=" + hit + ", fname=" + fname + ", fsize=" + fsize
				+ "]";
	}
	
}
