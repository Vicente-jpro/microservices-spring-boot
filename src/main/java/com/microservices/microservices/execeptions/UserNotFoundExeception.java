package com.microservices.microservices.execeptions;

public class UserNotFoundExeception extends RuntimeException{

	public UserNotFoundExeception(String message) {
		super(message);
	}
}
