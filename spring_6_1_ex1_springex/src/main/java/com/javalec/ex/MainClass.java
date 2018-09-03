package com.javalec.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		String configLocation1 = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX1.xml";
		String configLocation3 = "classpath:*.xml";
		
		// 두 개의 xml 파일 둘 다 읽어오기
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation3);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());	//홍길동
		System.out.println(student1.getHobbys());	// 수영, 요리
		
		StudentInfo studentInfo = ctx.getBean("sutudentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();	//student1  == student2
		System.out.println(student2.getName());	//홍길동
		System.out.println(student2.getHobbys());	// 수영, 요리
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		System.out.println("-------------------");
		student2.setName("ttt");
		System.out.println(student1.getName());
		System.out.println("-------------------");
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3.getName());
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		} else {
			System.out.println("student1 != student3");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		ctx.close();
		
	}
	
}
