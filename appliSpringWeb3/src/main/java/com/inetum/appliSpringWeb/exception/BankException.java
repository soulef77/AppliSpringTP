package com.inetum.appliSpringWeb.exception;

public class BankException extends RuntimeException {

	public BankException() {
		
	}
	
	public BankException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public BankException(String message, Throwable cause) {
		super(message, cause);
	}

}
