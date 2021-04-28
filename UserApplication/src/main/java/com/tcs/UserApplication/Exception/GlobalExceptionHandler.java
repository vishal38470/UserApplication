package com.tcs.UserApplication.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tcs.UserApplication.Exception.CustomErrorDetails;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	//MethodArgumentNotValidException
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails methodArgumentNotValid= new 
				CustomErrorDetails(new Date(), "Invalid arguments has been passed", ex.getMessage()
						);
		  
	return new ResponseEntity<Object>(methodArgumentNotValid,HttpStatus.BAD_REQUEST);
	}

	
	
	
	
	
	
	
}
