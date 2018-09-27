package com.javalec.spring_14_2_ex1_srpingex;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Test {
	@NotNull
	@NotEmpty
	private String name;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
