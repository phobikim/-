package com.sist.board.vo;


import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	private MultipartFile uploadFile;
	private int b_ref;
	private int b_step;
	private int b_level;
}









