package com.sist.board;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sist.board.db.DBManager;
import com.sist.board.vo.Sist_log;

@Aspect
@Component
public class ControllerLogging {

	@Pointcut("execution(public * com.sist.board.controller..*(..))")
	private void logTarget() {}
	
	@Around("logTarget()")
	public Object pro(ProceedingJoinPoint joinPoint) {		
		Object re = null;
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];
		String uri = request.getRequestURI();
		String ip = request.getRemoteAddr();
		Date today = new Date();
		int year = today.getYear()+1900;
		int month = today.getMonth()+1;
		int day = today.getDate();
		int hh = today.getHours();
		int mm = today.getMinutes();
		int ss = today.getSeconds();
		long start = System.currentTimeMillis();
		
		try {
			re = joinPoint.proceed();
		}catch (Throwable e) {
			// TODO: handle exception
		}
		
		long end = System.currentTimeMillis();
		/*
			listBoard.do/ 2021년3월9일11:29/ 3000/ 192.123.123.1 
		 */
		
		System.out.println(uri+"/ "+year+"년"+month+"월"+day+"일"+hh+":"+mm+":"+ss+"/ "+(end-start)+"/ "+ip);
		
		String time = year+"년"+month+"월"+day+"일"+hh+":"+mm+":"+ss;
		int stay = (int)(end-start);		
		
		Sist_log log = new Sist_log(ss, uri, time, stay, ip);
		DBManager.insertLog(log);
				
		
		return re;
	}
}







