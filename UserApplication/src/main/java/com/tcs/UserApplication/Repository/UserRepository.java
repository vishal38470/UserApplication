package com.tcs.UserApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.UserApplication.Entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

	
	UserEntity findByUsername(String username);
	
	
	
}
