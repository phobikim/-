package com.example.demo;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Pointcut("execution(public * com.example.demo.dao..*(..))")
	private void daoTarget() {}
	
	
	@After("daoTarget()")
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName+"이(가) 완료되었습니다.");
	}
	
	
	/*
	@AfterThrowing("daoTarget()")
	public void error(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName+"이(가) 비상정적으로 종료되었습니다.");
	}*/
	
	/*
	@AfterReturning("daoTarget()")
	public void success(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName+"정상 완료하였습니다.");
		System.out.println("-------------------------------------------");
	}*/
	
	/*
	@Around("daoTarget()")
	public Object around(ProceedingJoinPoint joinPoint) {
		System.out.println("----------------------------------------");
		String methodName = joinPoint.getSignature().getName();
		System.out.println(methodName+"이 동작하기 전입니다.");
		long start = System.currentTimeMillis();
		
		Object re = null;
		try {
			re= joinPoint.proceed();
		}catch (Throwable e) {
		}
		
		long end = System.currentTimeMillis();
		System.out.println(methodName+"이 동작한 후입니다.");
		System.out.println("걸린시간:"+(end-start));
		System.out.println("----------------------------------------");
		return re;
	}
	*/
	
	
	/*
	@Before("daoTarget()")
	public void before(JoinPoint joinpoint) {
		String methodName = joinpoint.getSignature().getName();
		System.out.println(methodName+"가 동작하기 전입니다.");
	}*/
	
}
