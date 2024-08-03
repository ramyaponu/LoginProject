package com.usermanagement.Exception;



import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(UserLoginServiceException.class)
	public ResponseEntity<Excepinformation> userManagementException(UserLoginServiceException exception){
		
		Excepinformation errorinformation=new Excepinformation();
		
		errorinformation.setErrorMessage(exception.getMessage());
		errorinformation.setErrorCode(HttpStatus.BAD_REQUEST.value());
		
		errorinformation.setOccuredAt(LocalDateTime.now());
		return new ResponseEntity<Excepinformation>(errorinformation,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Excepinformation> userGeneralException(Exception exception){
		
		Excepinformation errorinformation=new Excepinformation();
		
		errorinformation.setErrorMessage(exception.getMessage());
		errorinformation.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		errorinformation.setOccuredAt(LocalDateTime.now());
		return new ResponseEntity<Excepinformation>(errorinformation,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	

}
