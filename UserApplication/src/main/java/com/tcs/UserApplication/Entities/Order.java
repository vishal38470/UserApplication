package com.tcs.UserApplication.Entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Component
@Entity
@Table(name="orders")
public class Order extends RepresentationModel{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long orderid;
	
	
	private String orderDiscription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private UserEntity userEntity;

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getOrderDiscription() {
		return orderDiscription;
	}

	public void setOrderDiscription(String orderDiscription) {
		this.orderDiscription = orderDiscription;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
