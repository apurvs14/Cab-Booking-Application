package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class DriverManagementExceptionHandler {

	
	@ExceptionHandler(DriverNotFoundException.class)
	public ResponseEntity<MyErrorDetails> driverExceptionHandler1(DriverNotFoundException de, WebRequest req){
		
		MyErrorDetails med = new MyErrorDetails(LocalDateTime.now(),de.getMessage(),req.getDescription(false)); 
		
		return new ResponseEntity<>(med,HttpStatus.BAD_REQUEST);
		
	}
	
	
}
