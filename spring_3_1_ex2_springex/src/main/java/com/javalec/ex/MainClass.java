package com.javalec.ex;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		/*
		MyCalculator myCalculator = new MyCalculator();
		myCalculator.setCalculator(new Calculator());
		
		myCalculator.setFirstNum(10);
		myCalculator.setSecondNum(2);
		
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
		*/
		
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
//		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
//		
//		MyCalculator c2  = (MyCalculator)ctx.getBean("myCalculator");
//		
//		
//		myCalculator.add();
//		myCalculator.sub();
//		myCalculator.mul();
//		myCalculator.div();
		
		Test test = ctx.getBean("test", Test.class);
		
		// map
		Iterator<String> iter = test.getMap().keySet().iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key);
			System.out.println(test.getMap().get(key));
		}
		
		// list
		ArrayList<String> list = test.getList();
		for(String value : list) {
			System.out.println(value);
		}
		
		
		ctx.close();
	}
	
}
