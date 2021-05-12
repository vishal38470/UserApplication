package com.tcs.UserApplication.HelloWorldBean;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
public class HelloWorldBeanController {
	
	
	
	@GetMapping("/HelloWorldBean")  
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("vishal","Joshi","neemuch");
	}

	
	@GetMapping("/HelloWorld/int1")  
	public String helloWorld() {
		return "Hello";
	}
	
	
	
	
	
	
	
	
	
}
