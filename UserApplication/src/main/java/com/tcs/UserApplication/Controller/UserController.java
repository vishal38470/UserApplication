package com.tcs.UserApplication.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcs.UserApplication.Entities.UserEntity;
import com.tcs.UserApplication.Exception.UserExistException;
import com.tcs.UserApplication.Exception.UserNotFoundException;
import com.tcs.UserApplication.Services.UserService;
@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserService service;  
	
	@GetMapping("/users")
	public List<UserEntity> getAllUser(){
		
		return service.getAllUsers();
	} 
	  @CrossOrigin
	  @PostMapping("/users")
	  public ResponseEntity<Void> createUser(@RequestBody UserEntity user,UriComponentsBuilder builder) {
		  
		  try {
			 service.createUser(user);
			 HttpHeaders header = new HttpHeaders();
			header.setLocation(builder.path("/users/{id}").buildAndExpand(user.getID()).toUri());
			return new ResponseEntity<Void>(header,HttpStatus.CREATED);
			
		} catch (UserExistException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}  
		     
	  }      
	  @GetMapping("/users/{id}")
	public Optional<UserEntity> getUserById(@PathVariable Long id ) {
		try {
			return service.getUserById(id);
		} catch (UserNotFoundException e) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}	
	}
	  
	  @PutMapping("/users/{id}")
	  public UserEntity updateUserByID(@PathVariable long id, @RequestBody UserEntity user) {
		  
		  try {
			return service.UpdateUserById(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		} 
	  }
	  @DeleteMapping("/users/{id}")
	  public void deleteUserById(@PathVariable long id) {
		  service.delateUserByID(id);
		  
	  }
	  @GetMapping("/users/username/{username}")
	  public UserEntity userFindByUsername(@PathVariable String username) {
		  return service.findByUsername(username);
	  }
	  
}
	  
	  

