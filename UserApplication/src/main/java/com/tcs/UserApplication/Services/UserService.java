package com.tcs.UserApplication.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tcs.UserApplication.Entities.UserEntity;
import com.tcs.UserApplication.Exception.UserExistException;
import com.tcs.UserApplication.Exception.UserNotFoundException;
import com.tcs.UserApplication.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<UserEntity> getAllUsers(){
		return userRepo.findAll();			
	}
	
	public UserEntity createUser(UserEntity user) throws UserExistException {
		
		UserEntity existingUser = userRepo.findByUsername(user.getUsername());
		if(existingUser!=null) {
			
			throw new UserExistException("User already exists");
		}
		return userRepo.save(user);
	}
	
    public Optional<UserEntity> getUserById(Long id ) throws UserNotFoundException {
    	Optional<UserEntity> user = userRepo.findById(id);
    	
    	if(!user.isPresent()) {
    		
    		throw new UserNotFoundException("User not found exception has occured in Service class/getUserByID method");
    	}
    	
    	
    	return user;
    }

  public UserEntity UpdateUserById(long id,UserEntity user) throws UserNotFoundException {
	  Optional<UserEntity> optionalUser = userRepo.findById(id);
	  if(!optionalUser.isPresent()) {
		  throw new UserNotFoundException("User not found exeption fromupdateUserById/wrong id ");
	  }
	  
    	user.setID(id);
    	return userRepo.save(user);
    }
  public void delateUserByID(Long id) {
	 
	  Optional<UserEntity> optionalUser = userRepo.findById(id);
	  if(!optionalUser.isPresent()) {
		  throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not found exeption fromupdateUserById/wrong id ");
	  }
	  userRepo.deleteById(id);
	  
  }
	
  public UserEntity findByUsername( String username) {
	return userRepo.findByUsername(username);
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
	
	
}
