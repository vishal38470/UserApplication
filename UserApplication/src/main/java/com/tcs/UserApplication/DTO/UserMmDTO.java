package com.tcs.UserApplication.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;
import com.tcs.UserApplication.Entities.Views;

public class UserMmDTO {

	
	
	private Long ID ;
 
	private String username;

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}    
	
	
	
	
	
	
}
