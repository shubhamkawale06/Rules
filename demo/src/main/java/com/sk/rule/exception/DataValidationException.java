package com.sk.rule.exception;

public class DataValidationException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DataValidationException(String message) {
		super(message);
	}
	
	public DataValidationException(String message,Throwable cause) {
		super(message,cause);
	}

}
