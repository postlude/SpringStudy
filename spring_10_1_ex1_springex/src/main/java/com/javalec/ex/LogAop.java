package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	@Pointcut("within(com.javalec.ex.*)")
	private void pointcutMethod() {
	}
	
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println( signatureStr + " is start.");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr + " 경과시간 : " + (et - st));
		}
		
	}
	
	// around와 before가 같이 적용되면 around 먼저 실행 됨
	@Before("within(com.javalec.ex.*)")
	public void beforAdvice() {
		System.out.println("beforAdvice()");
	}
	
	// after는 around 보다 나중에 실행 됨
	@After("within(com.javalec.ex.*)")
	public void afterAdvice() {
		System.out.println("afterADvice()");
	}
}
