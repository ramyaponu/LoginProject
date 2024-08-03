package com.usermanagement.Repository;

import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usermanagement.Entity.UserDetails;

public interface UserRepository extends JpaRepository <UserDetails,Integer>{

	public UserDetails findByUserEmail(String userEmail);
	
	public UserDetails findByUserPhoneNumber(String userPhoneNumber);

	

	
	
	
}
