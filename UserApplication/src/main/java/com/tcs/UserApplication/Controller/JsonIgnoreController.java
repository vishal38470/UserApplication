package com.tcs.UserApplication.Controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.tcs.UserApplication.Entities.UserEntity;
import com.tcs.UserApplication.Exception.UserNotFoundException;
import com.tcs.UserApplication.Services.UserService;

@CrossOrigin
@RestController
@Validated
@RequestMapping(value = "/Jsonignore/users")
public class JsonIgnoreController {

	@Autowired
	UserService service;

	@GetMapping("/{id}")
	public MappingJacksonValue getUserById(@PathVariable Long id) {
		try {

			Set<String> setOfColumnsForFilter1 = new HashSet<String>();
			setOfColumnsForFilter1.add("username");
			setOfColumnsForFilter1.add("email");
			setOfColumnsForFilter1.add("role");

			FilterProvider filter1 = new SimpleFilterProvider().addFilter("userFilter",
					SimpleBeanPropertyFilter.filterOutAllExcept(setOfColumnsForFilter1));

			Optional<UserEntity> userOptional = service.getUserById(id);
			UserEntity user = userOptional.get();

			MappingJacksonValue mapper = new MappingJacksonValue(user);

			mapper.setFilters(filter1);

			return mapper;
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

}
