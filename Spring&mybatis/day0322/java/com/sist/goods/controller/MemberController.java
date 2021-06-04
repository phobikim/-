package com.sist.goods.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sist.goods.dao.MemberDao;
import com.sist.goods.vo.MemberVo;

@Controller
public class MemberController {

	@Autowired
	private MemberDao dao;

	public MemberDao getDao() {
		return dao;
	}
	
	
	// 그 사람이 회원이 맞는지 판별하는 것은 
	// 스프링 시큐리티가 알아서 해 줍니다.
	// 우리가 코딩하지 않았어요!
	// "너가 우리회원지 맞아"라고 판별은 스프링 시큐리티가 해 줘요.
	// 다만, 우리가 하는 것은 로그인을 성공하면 "loginOK.do"를 요청하세요!라고 
	// 설정을 했어요!
	// 근데 문제는 여기서 로그인한 회원의 정보가 필요해요,,,
	// 로그인한 회원을 알아야 그것을 session을 통해서 상태유지 할거에요...
	@RequestMapping("/loginOK.do")
	public ModelAndView loginOK(HttpSession session) {		
		System.out.println("로그인 성공!");		
		ModelAndView mav = new ModelAndView();
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		User user = (User)authentication.getPrincipal();
		String id = user.getUsername();
		MemberVo m= dao.getMember(id);
		session.setAttribute("m", m);	
		mav.setViewName("redirect:/listBoard.do");
		return mav;
	}
	
	@RequestMapping("/login.do")
	public void login() {		
	}
	
	
	
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public void insertForm() {
		
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(MemberVo m) {
		ModelAndView mav = new ModelAndView();		
		m.setPwd(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(m.getPwd()));		
		int re = dao.insert(m);
		if(re == 1) {
			mav.setViewName("redirect:/index.html");
		}
		return mav;
	}
}























