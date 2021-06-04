package com.sist.goods;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		
		http.authorizeRequests()
		.mvcMatchers("/", "/join.do", "/login.do").permitAll()
		.mvcMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated();
		
		http.formLogin().loginPage("/login.do").permitAll()
		.defaultSuccessUrl("/loginOK.do");
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/login.do");
		
		http.httpBasic();
	}

	
	
}









