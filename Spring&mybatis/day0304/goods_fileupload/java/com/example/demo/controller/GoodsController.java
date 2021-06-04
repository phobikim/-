package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDao;
import com.example.demo.util.SistUtil;
import com.example.demo.vo.GoodsVo;

@Controller
public class GoodsController {

	@Autowired
	private GoodsDao dao;
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.selectGoods(no));
		return mav;
	}
	
	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(GoodsVo g, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String path = request.getRealPath("/img");
		String oldFname = g.getFname();
		
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		
		if(fname != null && !fname.equals("")) {
			
			fname = SistUtil.getFileName(fname, path);
			
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
		if(re == 1) {
			if(fname != null && !fname.equals("")) {
				File file = new File(path+"/"+oldFname);
				file.delete();
			}
			mav.setViewName("redirect:/listGoods.do");
		}else {
			mav.addObject("msg", "상품수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	
	
	@RequestMapping("/deleteGoods.do")
	public ModelAndView delete(int no, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String path = request.getRealPath("/img");
		String oldFname = dao.selectGoods(no).getFname();
		int re = dao.deleteGoods(no);
		if(re == 1) {
			File file = new File(path+"/"+oldFname);
			file.delete();
			mav.setViewName("redirect:/listGoods.do");
		}else {
			mav.addObject("msg", "상품삭제에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	
	@RequestMapping("/detailGoods.do")
	public ModelAndView detail(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.selectGoods(no));
		return mav;
	}
	
	

	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.GET)
	public void inserForm() {
		
	}
	
	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(GoodsVo g, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String path = request.getRealPath("/img");
		System.out.println("path:"+path);
		
		MultipartFile uploadFile = g.getUploadFile();
		if(uploadFile != null) {
			try {
				byte []data  = uploadFile.getBytes();
				String fname = uploadFile.getOriginalFilename();
				fname = SistUtil.getFileName(fname, path);
				FileOutputStream fos = new FileOutputStream(path+"/"+fname);
				fos.write(data);
				fos.close();
				g.setFname(fname);
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		
		int re = dao.insertGoods(g);
		if(re == 1) {
			mav.setViewName("redirect:/listGoods.do");
		}else {
			mav.addObject("msg", "상품등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	
	
	
	@RequestMapping("/listGoods.do")
	public ModelAndView listGoods() {
		System.out.println("컨트롤러 동작함!");
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.findAll());
		return mav;
	}
}













