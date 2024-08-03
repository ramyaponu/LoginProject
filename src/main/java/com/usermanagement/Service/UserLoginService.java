package com.usermanagement.Service;



import java.util.Optional;

import com.usermanagement.Entity.UserDetails;
import com.usermanagement.Exception.UserLoginServiceException;
import com.usermanagement.Model.UserDto;

public interface UserLoginService {
   
	
	
	
	public void userLogin(UserDto userdata) throws UserLoginServiceException, Exception;

	
}
