package com.microservices.microservices.execeptions;

public class UserNotFoundExeception extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundExeception(String message) {
		super(message);
	}
}
