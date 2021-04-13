package com.tcs.UserApplication.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tcs.UserApplication.Entities.UserEntity;
import com.tcs.UserApplication.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<UserEntity> getAllUsers(){
		return userRepo.findAll();			
	}
	
	public UserEntity createUser(UserEntity user) {
		return userRepo.save(user);
	}
	
    public Optional<UserEntity> getUserById(Long id ) {
    	Optional<UserEntity> user = userRepo.findById(id);
    	return user;
    }

  public UserEntity UpdateUserById(long id,UserEntity user) {
    	user.setID(id);
    	return userRepo.save(user);
    }
  public void delateUserByID(Long id) {
	  if(userRepo.findById(id).isPresent()) {
		  userRepo.deleteById(id);
		 
	  }
	  
  }
	
  public UserEntity findByUsername( String username) {
	return userRepo.findByUsername(username);
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
	
	
}
