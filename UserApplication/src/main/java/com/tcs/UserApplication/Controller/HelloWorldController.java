/*
 * package com.tcs.UserApplication.Controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.i18n.LocaleContextHolder; import
 * org.springframework.context.support.ResourceBundleMessageSource; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * @RestController
 * 
 * @CrossOrigin public class HelloWorldController {
 * 
 * @Autowired ResourceBundleMessageSource messageSource;
 * 
 * 
 * @GetMapping("/helloworld") public String helloWorld() {
 * 
 * //return "Hello world";
 * 
 * return messageSource.getMessage("label.Hello", null,
 * LocaleContextHolder.getLocale() );
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */