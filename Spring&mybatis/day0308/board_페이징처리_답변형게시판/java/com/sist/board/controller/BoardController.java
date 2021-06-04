package com.sist.board.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sist.board.SistUtil;
import com.sist.board.dao.BoardDao;
import com.sist.board.vo.BoardVo;

@Controller
public class BoardController {
	
	public static int pageSIZE = 10;
	public static int totalRecord = 0;
	public static int totalPage = 1;
	
	@Autowired
	private BoardDao dao;
	
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/updateBoard.do",method = RequestMethod.GET)
	public ModelAndView updateForm(int no) {
		ModelAndView mav = new  ModelAndView();
		mav.addObject("b", dao.getBoard(no));
		return mav;
	}
	
	@RequestMapping(value = "/updateBoard.do",method = RequestMethod.POST)
	public ModelAndView updateSubmit(BoardVo b, HttpServletRequest request) {
		//이미 BoardVo객체인 b에는 원래 파일명과 파일크기를 담고 있어요!
		
		String path = request.getRealPath("/file");
		String oldFname = b.getFname();		
		ModelAndView mav = new  ModelAndView();
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				fname = SistUtil.getFileName(fname, path);

				byte []data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/" +fname);
				fos.write(data);;
				fos.close();
				
				b.setFname(fname);
				b.setFsize(data.length);
				
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			
		}
		
		int re = dao.updateBoard(b);
		if(re == 1) {
			if(fname != null && !fname.equals("") && oldFname != null && !oldFname.equals("")) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
			mav.setViewName("redirect:/listBoard.do");
		}else {
			mav.addObject("msg", "게시물 수정에 실패하였습니다.");
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	
	@RequestMapping(value = "/deleteBoard.do", method = RequestMethod.GET)
	public ModelAndView deleteForm(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("no",no);
		return mav;
	}
	
	@RequestMapping(value = "/deleteBoard.do", method = RequestMethod.POST)
	public ModelAndView deleteSubmit(int no, String pwd, HttpServletRequest request) {
		String path = request.getRealPath("/file");
		String fname = dao.getBoard(no).getFname();
		
		ModelAndView mav = new ModelAndView();
		int re = dao.deleteBoard(no, pwd);
		if(re == 1) {
			if(fname != null && !fname.equals("")) {
				File file = new File(path + "/" + fname);
				file.delete();
			}
			
			mav.setViewName("redirect:/listBoard.do");
		}else {
			mav.addObject("msg", "삭제에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public ModelAndView insertForm(@RequestParam(value = "no", defaultValue = "0")  int no) {
		String title = "새글작성";
		if(no!=0) {
			title = "답글작성";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", no);
		mav.addObject("title", title);
		return mav;
	}
	
	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(BoardVo b, HttpServletRequest request) {
		
		//일단은 최초의 부모글이라고 보고 
		//b_ref는 글번호와 동일하게
		//b_step, b_level은 0을 설정
		
		int no = dao.getNextNo();
		int b_ref= no;
		int b_step = 0;
		int b_level = 0;
		
		//만약에 답글인지??
		int p_no= b.getNo();
		if(p_no != 0) {
			BoardVo p = dao.getBoard(p_no);
			b_ref = p.getB_ref();
			b_step = p.getB_step();
			b_level = p.getB_level();
			dao.updateStep(b_ref, b_step);
			b_step++;
			b_level++;
		}
		
		b.setNo(no);
		b.setB_ref(b_ref);
		b.setB_step(b_step);
		b.setB_level(b_level);
		
		
		ModelAndView mav = new ModelAndView();
		String path = request.getRealPath("/file");
		System.out.println("path:"+path);
		b.setIp(request.getRemoteAddr());
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		b.setFname("");
		b.setFsize(0);
		if(fname != null && !fname.equals("")) {
			try {
				byte []data = uploadFile.getBytes();
				fname = SistUtil.getFileName(fname, path);
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
				b.setFname(fname);
				b.setFsize(data.length);
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
		
		int re = dao.insertBoard(b);
		if(re == 1) {
			mav.setViewName("redirect:/listBoard.do");
		}else {
			mav.addObject("msg", "게시물 등록에 실패하였습니다.");
			mav.setViewName("error");
		}
		return mav;
	}
	
	
	@RequestMapping("/detailBoard.do")
	public ModelAndView detailBoard(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.getBoard(no));
		return mav;
	}
	
	
	@RequestMapping("/listBoard.do")
	public ModelAndView listBoard(@RequestParam(value = "pageNUM", defaultValue = "1")   int pageNUM) {
		totalRecord = dao.totBoard();
		totalPage =  (int) Math.ceil( totalRecord / (double)pageSIZE) ;
		
		System.out.println("pageNUM:"+pageNUM);
		
		// 우리는 한화면에 10개씩 보여주고 싶어요    ==> pageSIZE
		// 만약 현재페이지가 1페이지라면 보여줘야 할 시작레코드는 1
		// 만약 현재페이지가 2페이지라면 보여줘야 할 시작레코드는 11 
		
		
		int start = (pageNUM-1)*pageSIZE+1;
		int end = start+pageSIZE-1;
		
		System.out.println("시작레코드:"+start);
		System.out.println("끝나는레코드:"+end);
		System.out.println("-------------------------------");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listBoard(start,end));
		mav.addObject("totalPage", totalPage);
		return mav;
	}
}








