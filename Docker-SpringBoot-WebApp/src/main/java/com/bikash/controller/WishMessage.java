package com.bikash.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class WishMessage {
	
	@GetMapping("/message/{name}")
	public ResponseEntity<String> getMessage(@PathVariable String name)
	{
		return new ResponseEntity<String>("Good Morning "+name,HttpStatus.OK);
	}
}
