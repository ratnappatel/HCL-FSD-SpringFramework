package com.hcl.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dto.UserDTO;
import com.hcl.dto.UserLoginDTO;
import com.hcl.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService uService;

	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session)
	{
		session.invalidate();
		return new ResponseEntity<>("Logout Successfully",HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO)
	{
		UserDTO userDTO=uService.getUserDetails(userLoginDTO);
		System.out.println(userDTO);
		return new ResponseEntity<>("Login Successful",HttpStatus.OK);
	}
	
	
	@GetMapping("/items")
	public ResponseEntity<List<String>> getAllItem()
	{
		List<String> items=new ArrayList<String>();
		items.add("Noodles");
		items.add("Chowmein");
		
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
	/*@GetMapping("/items/{id}")
	
	@PostMapping("/order/{itemId}")
	public void placeOrder(@RequestBody OrderDTO orderDTO)
	{
		
	}*/
}
