package com.tcs.UserApplication.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tcs.UserApplication.Entities.Order;
import com.tcs.UserApplication.Entities.UserEntity;
import com.tcs.UserApplication.Exception.UserNotFoundException;
import com.tcs.UserApplication.Repository.OrderRepository;
import com.tcs.UserApplication.Repository.UserRepository;

@Service
public class OrderService {

	
	@Autowired  
	OrderRepository orderRepo;   
	
	@Autowired  
	UserRepository userRepo;
	
	public List<Order> listOfAllOrders(Long id) throws UserNotFoundException {
		
	
	Optional<UserEntity> user = userRepo.findById(id);
	if(!user.isPresent()) {
		throw new UserNotFoundException("UNF exception from Orser service class/listOfAllOrders method");
	}
       return user.get().getOrders();		
	}
	
	
	/*
	 * public Order createOrder(@PathVariable Long userId, @RequestBody Order order)
	 * throws UserNotFoundException {
	 * 
	 * Optional<UserEntity> user = userRepo.findById(userId); if(!user.isPresent())
	 * { throw new
	 * UserNotFoundException("UNF exception from Orser service class/createOrders method"
	 * ); }
	 * 
	 * UserEntity user1 = user.get(); order.setUserEntity(user1); return
	 * orderRepo.save(order);
	 * 
	 * }
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
