package com.usermanagement.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.usermanagement.Entity.UserDetails;
import com.usermanagement.Exception.UserLoginServiceException;
import com.usermanagement.Model.UserDto;
import com.usermanagement.Repository.UserRepository;
import com.usermanagement.Utility.UserServiceConstants;



@Service(value="UserLoginServiceImpl")

public class UserLoginServiceImpl implements UserLoginService{

	@Autowired
	UserRepository userrepository;
	
	@Transactional(rollbackForClassName = "UserLoginServiceException")
	public void userLogin(UserDto userdata) throws UserLoginServiceException {
		
		
	if(userdata.getUserEmail()==null && userdata.getUserPhoneNumber()==null) 
	throw new UserLoginServiceException(UserServiceConstants.PHONE_OR_EMAIL_MANDATORY);
	
			
		
	if(userdata.getUserEmail()!=null) {
		UserDetails userdetails=userrepository.findByUserEmail(userdata.getUserEmail());
		
			if(userdetails!=null)
				throw new UserLoginServiceException(UserServiceConstants.EMAIL_ALREADY_REGISTERED);
			
			
		}
		
		
		
	if(userdata.getUserPhoneNumber()!=null) {
		UserDetails userdetails=userrepository.findByUserPhoneNumber(userdata.getUserPhoneNumber());
		
		if(userdetails!=null)
          throw new UserLoginServiceException(UserServiceConstants.PHONE_NUMBER_ALREADY_REGISTERED);
			
	
	}
	save(userdata);
	
}

	private String save(UserDto userdata) {
		UserDetails userde=new UserDetails();
		
		userde.setUserName(userdata.getUserName());
		userde.setUserPassword(userdata.getUserPassword());
		userde.setUserEmail(userdata.getUserEmail());
		userde.setUserPhoneNumber(userdata.getUserPhoneNumber());
		userde=userrepository.save(userde);
		return "user details added";

		 
		
	}
	
	
}
