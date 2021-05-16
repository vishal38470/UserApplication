package com.tcs.UserApplication.Controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.tcs.UserApplication.DTO.UserMmDTO;
import com.tcs.UserApplication.Entities.UserEntity;
import com.tcs.UserApplication.Exception.UserNotFoundException;
import com.tcs.UserApplication.Services.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class ModelMapperController {

	@Autowired
	UserService service;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/modelMapper/{id}")
	public UserMmDTO getUserById(@PathVariable Long id) {
		try {
			Optional<UserEntity> userOptional = service.getUserById(id);
			UserEntity user = userOptional.get();
			UserMmDTO userDTO = modelMapper.map(user, UserMmDTO.class);
			return userDTO;

		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}
}
