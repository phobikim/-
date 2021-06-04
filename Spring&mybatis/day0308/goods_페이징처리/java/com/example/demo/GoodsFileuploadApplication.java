package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.util.SistUtil;
import com.example.demo.vo.GoodsVo;

@SpringBootApplication
public class GoodsFileuploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsFileuploadApplication.class, args);
	
//		String path = "C:\\stsTest\\goods_fileupload\\src\\main\\webapp\\img";
//		String fname = "hello.jpg";
//		
//		String newFileName = SistUtil.getFileName(fname, path);
//		System.out.println(newFileName);		
//				
		
		
		//GoodsVo g = new GoodsVo();
		//g.setName("축구공");
		//System.out.println(g.getName());
		
		//GoodsVo g = new GoodsVo(1000, "축구공", 10, 35000, "ball1.jpg");
		//System.out.println(g);
		//System.out.println(g.getPrice());
	}

}








