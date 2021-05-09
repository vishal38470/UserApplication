package com.tcs.UserApplication.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.UserApplication.Entities.Order;
import com.tcs.UserApplication.Entities.UserEntity;
import com.tcs.UserApplication.Exception.UserNotFoundException;
import com.tcs.UserApplication.Repository.OrderRepository;
import com.tcs.UserApplication.Repository.UserRepository;
import com.tcs.UserApplication.Services.OrderService;

@CrossOrigin
@RestController
@RequestMapping(value="/users")
public class OrderController {

	
	@Autowired
	OrderService orderService;
	@Autowired  
	OrderRepository orderRepo;
	
	@Autowired  
	UserRepository userRepo;
	
	@GetMapping("/{id}/orders")
	public List<Order>  getAllOrdersFromUser(@PathVariable Long id) throws UserNotFoundException
	{
	 
	return orderService.listOfAllOrders(id);
	 
	 
	}
	
	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId, @RequestBody Order order) throws UserNotFoundException
	{
		
		Optional<UserEntity> user = userRepo.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("UNF exception from Orser service class/createOrders method");
		}
		
		UserEntity user1 = user.get();
		order.setUserEntity(user1);
		return orderRepo.save(order);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
