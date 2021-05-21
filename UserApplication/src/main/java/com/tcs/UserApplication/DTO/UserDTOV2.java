package com.tcs.UserApplication.DTO;

import java.util.List;

import com.tcs.UserApplication.Entities.Order;

public class UserDTOV2 {
	private Long ID;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private String role;
	private String SSN;
	private List<Order> orders;
	private String address;
	public UserDTOV2(Long iD, String username, String firstName, String lastName, String email, String role, String sSN,
			List<Order> orders,String address) {
		super();
		ID = iD;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		SSN = sSN;
		this.orders = orders;
		this.address= address;
		
	}
	public UserDTOV2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
