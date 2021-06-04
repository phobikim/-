package com.sist.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sist.goods.dao.MemberDao;
import com.sist.goods.vo.MemberVo;

// 스프링 시큐리티 환경에서는 
// 로그인을 위한 아이디와 암호를 입력받는 폼은 우리가 만들 수 있어요.
// 실제로 로그인 처리를 하는 것은 스프링 시큐리티가 담당해요!
// 그때에 사용자가 입력한 아이디를 매개변수로 하여 
// 다음의 loadUserByUsername(String username)  이 메소드가 사용으로 호출됩니다ㅣ!



@Service
public class MemberService implements UserDetailsService {
	
	@Autowired
	private MemberDao dao;
	
	public MemberDao getDao() {
		return dao;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername 동작함! "+username);
		
		// TODO Auto-generated method stub
		
		// 이 메소드 안에서 우리 할 일은
		// 그 아이디에 해당하는 회원이 있는지 판별하여 
		// 만약에 없다면 예외를 발생시키고 
		// 있다면 그 회원의 아이디,암호,롤의 정보를 UserDetails객체로 
		// 포장하여 반환하도록 합니다.
		MemberVo m = dao.getMember(username);
		if(m == null) {
			throw new UsernameNotFoundException(username);
		}
		
		System.out.println("회원정보:"+m);
		
		return User.builder()
				.username(username)
				.password(m.getPwd())
				.roles(m.getRole()).build();
		/*
		UserDetails details = null;
		
		UserBuilder builder = User.builder();
		builder.username(username);
		builder.password(m.getPwd());
		builder.roles(m.getRole());
		details= builder.build();
		return details;*/
		
	}

}




