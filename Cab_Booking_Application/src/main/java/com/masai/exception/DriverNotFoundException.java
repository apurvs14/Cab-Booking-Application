package com.masai.exception;



public class DriverNotFoundException extends RuntimeException {

	public DriverNotFoundException() {
		
	}
	public DriverNotFoundException(String msg) {
		super(msg);
	}
}
