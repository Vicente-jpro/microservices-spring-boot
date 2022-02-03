package com.microservices.microservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@ResponseBody
	@GetMapping(value = "/", produces= "application/json")
	public ResponseEntity<String> index(@RequestParam("name") String name) {
		return new ResponseEntity<String>(name, HttpStatus.OK);
	}
}
