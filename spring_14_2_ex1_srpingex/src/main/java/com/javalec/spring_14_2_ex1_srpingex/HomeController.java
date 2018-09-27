package com.javalec.spring_14_2_ex1_srpingex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/studentView")
	public String studentView(@ModelAttribute("studentInfo") StudentInformation studentInformation){
		return "studentView";
	}
	
	@RequestMapping("/index2")
	public String index2() {
		return "index2";
	}
	
	// method 레벨에서 사용하면 @Controller 클래스 안에 있는 모든 @RequestMapping 이 붙은 메소드를 호출하기 전에 무조건 호출돼서 model에 객체를 집어 넣는다.
	// 일종의 default 값을 지정할 수 있음
	@ModelAttribute("modelAttribute")
	public String modelAttribute() {
		return "test";
	}
	
	@RequestMapping("/validTest/index3")
	public String index3() {
		return "validTest/index3";
	}
	
	@RequestMapping("/validTest/result")
	public String index4(@Valid Test test, BindingResult result) {
		if(result.hasErrors()) {
			return "validTest/error";
		}
		return "validTest/result";
	}
}
