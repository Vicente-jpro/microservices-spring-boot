package com.microservices.microservices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices.domain.User;
import com.microservices.microservices.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<List<User>> readAll(){
		List userList = userService.readAll();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}   
	
	@PostMapping( value = "/add", produces = "application/json")
	public ResponseEntity<User> create(@RequestBody User user){
		return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
	}
}
