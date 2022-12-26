package com.gl.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"http://localhost:3000","http://localhost:4200"})
public class HelloController {
	
	@GetMapping("/user")
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
