package com.usermanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.Entity.UserDetails;
import com.usermanagement.Model.UserDto;
import com.usermanagement.Service.UserLoginServiceImpl;

import jakarta.validation.Valid;

@RestController
@Validated
public class UserLoginController {
	
	@Autowired
	UserLoginServiceImpl userservice;
    
	@PostMapping("/user-login")
	public ResponseEntity<String> Userlogin(@RequestBody  UserDto user) throws Exception {
		          userservice.userLogin(user);
		return new ResponseEntity<String> (HttpStatus.CREATED);
	}
}
