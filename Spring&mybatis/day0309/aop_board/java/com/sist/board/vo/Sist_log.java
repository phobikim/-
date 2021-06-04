package com.sist.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sist_log {
	private int no;
	private String uri;
	private String time;
	private int stay;
	private String ip;
}
