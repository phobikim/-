package com.sist.goods.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.sist.goods.dao.GoodsDao;
import com.sist.goods.vo.GoodsResponse;
import com.sist.goods.vo.GoodsVo;


@RestController
public class GoodsController {
	
	public static int pageSIZE = 5;
	public static int totalRecord=0;
	public static int totalPage = 1;
	
	@Autowired
	private GoodsDao dao;

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/deleteGoods.do")
	public String deleteGoods(int no, HttpServletRequest request) {
		String oldFname = dao.selectGoods(no).getFname();
		int re = dao.deleteGoods(no);
		if(re == 1) {
			String path = request.getRealPath("img");
			File file = new File(path + "/" +oldFname);
			file.delete();
		}
		return "OK";
	}
	
	
	@RequestMapping("/updateGoods.do")
	public String updateGoods(GoodsVo g, HttpServletRequest request) {
		String oldFname = g.getFname();
		String path = request.getRealPath("img");
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				g.setFname(fname);
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		int re = dao.updateGoods(g);
		if(re == 1 && fname != null && !fname.equals("")) {
			File file = new File(path + "/" + oldFname );
			file.delete();
		}
		
		
		return re+"";
	}
	
	
	
	@RequestMapping("/insertGoods.do")
	public String insertGoods(GoodsVo g, HttpServletRequest request) {
		String path = request.getRealPath("img");
		System.out.println("path:"+path);
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		
		g.setFname(fname);
		int re = dao.insertGoods(g);
		
		System.out.println(g);
		return re+"";
	}
	
	
	@RequestMapping("/listGoods.do")
	public String listGoods(int pageNUM) {
		totalRecord = dao.getTotalRecord();
		totalPage =  (int)Math.ceil(totalRecord/ (double)pageSIZE);
		
		int start = (pageNUM-1)*pageSIZE+1;
		int end = start+pageSIZE-1;
		
		List<GoodsVo> list = dao.findAll(start, end);
		
		GoodsResponse r = new GoodsResponse();
		r.setTotalPage(totalPage);
		r.setList(list);
		
		Gson gson = new Gson();
		return  gson.toJson(r);
	}
	
}	







