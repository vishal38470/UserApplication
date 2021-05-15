package com.tcs.UserApplication.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;
import com.tcs.UserApplication.Entities.UserEntity;
import com.tcs.UserApplication.Entities.Views;
import com.tcs.UserApplication.Exception.UserNotFoundException;
import com.tcs.UserApplication.Services.UserService;

@CrossOrigin
@RestController
@Validated
@RequestMapping(value="/users")
public class JsonViewController {

	
	@Autowired
	UserService service;  
	
	
	  @JsonView(Views.External.class)
	  @GetMapping("/external/{id}")
		public Optional<UserEntity> getUserById(@PathVariable Long id ) {
			try {
				return service.getUserById(id);
			} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
			}	
		}
	
	
	  @JsonView(Views.Internal.class)
	  @GetMapping("/internal/{id}")
		public Optional<UserEntity> getUserById2(@PathVariable Long id ) {
			try {
				return service.getUserById(id);
			} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
			}	
		}
	
	  
	  
	  
	  
	  
	  
	  
	
}
