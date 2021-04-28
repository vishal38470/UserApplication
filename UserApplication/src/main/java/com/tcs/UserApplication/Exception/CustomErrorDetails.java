package com.tcs.UserApplication.Exception;

import java.util.Date;

public class CustomErrorDetails {

	Date timestamp;
	String message;
	String errordetails;
	public CustomErrorDetails(Date timestamp, String message, String errordetails) {
		super();
		this.timestamp = timestamp;
		this.message = message; 
		this.errordetails = errordetails;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getErrordetails() {
		return errordetails;
	}
	
	
	
	
	
	
}
