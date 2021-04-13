package com.tcs.UserApplication.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.UserApplication.Entities.UserEntity;
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
	  public UserEntity createUser(@RequestBody UserEntity user) {
		  
		  return service.createUser(user);
		  
	  }  
	  @GetMapping("/users/{id}")
	public Optional<UserEntity> getUserById(@PathVariable Long id ) {
		return service.getUserById(id);	
	}
	  
	  @PutMapping("/users/{id}")
	  public UserEntity updateUserByID(@PathVariable long id, @RequestBody UserEntity user) {
		  
		  return service.UpdateUserById(id, user); 
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
	  
	  

