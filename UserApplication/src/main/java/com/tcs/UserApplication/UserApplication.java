package com.tcs.UserApplication;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;  

@SpringBootApplication
public class UserApplication {
//fghf
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);  
	};

	@Bean
	public AcceptHeaderLocaleResolver localResolver() {
		
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		
		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
		
	}
	
	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource() {
		
		ResourceBundleMessageSource baseMessageName = new ResourceBundleMessageSource();
		baseMessageName.setBasenames("messages");
		
		return baseMessageName;
		
	}
	
	
	
	
	
}
