package com.javalec.ex;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();	// 생성

		ctx.load("classpath:applicationCTX.xml");	// 설정
		
		ctx.refresh();
		
		Student student2 = ctx.getBean("student", Student.class);	// 사용
		System.out.println("이름 : " + student2.getName());
		System.out.println("나이 : " + student2.getAge());
		
		ctx.close();															// 종료
		
	}
	
}
