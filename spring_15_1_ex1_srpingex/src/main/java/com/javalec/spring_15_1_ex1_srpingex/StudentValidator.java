package com.javalec.spring_15_1_ex1_srpingex;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		System.out.println("suppoerts() call");
		return Student.class.isAssignableFrom(arg0);  // 검증할 객체의 클래스 타입 정보
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate() call");
		Student student = (Student)obj;
		
		String studentName = student.getName();
		if(studentName == null || studentName.trim().isEmpty()) {
//			System.out.println("studentName is null or empty");
			errors.rejectValue("name", "nameError", "studentName is null or empty");
		}
		
		int studentId = student.getId();
		if(studentId == 0) {
//			System.out.println("studentId is 0");
			errors.rejectValue("id", "idError", "studentId is 0");
		}
	}
	
}
