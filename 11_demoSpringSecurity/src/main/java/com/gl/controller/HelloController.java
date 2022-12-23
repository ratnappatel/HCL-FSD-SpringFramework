package com.gl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello  World";
	}
	
	@GetMapping("/admin")
	public String welcomeAdmin()
	{
		return "Hello Admin ";
	}

}
