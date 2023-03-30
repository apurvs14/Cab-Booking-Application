package com.masai.exception;

public class CabException extends RuntimeException {
	public CabException() {
		// TODO Auto-generated constructor stub
	}

	public CabException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	public CabException(String msg, Exception e) {
		super(msg);
		e.getMessage();
	}
}
