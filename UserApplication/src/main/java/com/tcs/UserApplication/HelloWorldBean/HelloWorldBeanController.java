package com.tcs.UserApplication.HelloWorldBean;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloWorldBeanController {
	
	
	
	@GetMapping("/HelloWorldBean")  
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("vishal","Joshi","neemuch");
		
		
	}

}
