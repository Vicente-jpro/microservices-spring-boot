package com.microservices.microservices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices.domain.User;
import com.microservices.microservices.dto.UserDto;
import com.microservices.microservices.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController{

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<List<User>> readAll(){
		List<User> userList = userService.readAll();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}   
	
	@PostMapping( value = "/add", produces = "application/json")
	public ResponseEntity<User> create(@RequestBody User user){
		return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
	}
	
	@PutMapping( value = "/add", produces = "application/json")
	public ResponseEntity<User> update(@RequestBody User user){
		return new ResponseEntity<User>(userService.create(user), HttpStatus.CREATED);
	}
	
	@GetMapping( value = "/get/{id}", produces = "application/json")
	public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id){
		UserDto user = userService.getUser(id);
		return new ResponseEntity<UserDto>( user, HttpStatus.OK);
	}
	
	@DeleteMapping( value = "/delete/{id}", produces = "application/json")
	public ResponseEntity<User> delete(@PathVariable("id") Long id){
		userService.delete(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	} 
	
	@GetMapping(value = "/search/{name}", produces = "application/json")
	public ResponseEntity<List<User>> findByName(@PathVariable("name") String name){
		List<User> usersList = userService.findUserByName(name);
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}
}
