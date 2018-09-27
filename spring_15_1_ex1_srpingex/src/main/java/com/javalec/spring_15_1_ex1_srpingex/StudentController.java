package com.javalec.spring_15_1_ex1_srpingex;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(@ModelAttribute("student") Student student, BindingResult result, Model model) {
		
		String page = "createDonePage";
		
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		if(result.hasErrors()) {
			List<FieldError> errorList = result.getFieldErrors();
			model.addAttribute("errorList", errorList);
			page = "errorPage";
		}
		
		return page;
	}
}
