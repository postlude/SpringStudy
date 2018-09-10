package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	// ProceedingJoinPoint 는 around로 지정된 advice에만 사용 가능
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
	
	public void test() {
		System.out.println("test");
	}
}
