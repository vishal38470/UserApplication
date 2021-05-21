package com.tcs.UserApplication.Controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tcs.UserApplication.DTO.UserDTOV1;
import com.tcs.UserApplication.DTO.UserDTOV2;
import com.tcs.UserApplication.DTO.UserMmDTO;
import com.tcs.UserApplication.Entities.UserEntity;
import com.tcs.UserApplication.Exception.UserNotFoundException;
import com.tcs.UserApplication.Services.UserService;

@CrossOrigin
@Validated
@RestController
@RequestMapping(value="/versioning/uri/users")
public class URIController {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	UserService service;
	
	@GetMapping("/v1.0/{id}")
	public UserDTOV1 getUserById(@PathVariable Long id) {
		try {
			Optional<UserEntity> userOptional = service.getUserById(id);
			UserEntity user = userOptional.get();
			UserDTOV1 userDTO = modelMapper.map(user, UserDTOV1.class);
			return userDTO;

		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	@GetMapping("/v2.0/{id}")
	public UserDTOV2 getUserById2(@PathVariable Long id) {
		try {
			Optional<UserEntity> userOptional = service.getUserById(id);
			UserEntity user = userOptional.get();
			UserDTOV2 userDTO = modelMapper.map(user, UserDTOV2.class);
			return userDTO;

		} catch (UserNotFoundException e) {    
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
	
	
	
	
	
	
	
}
