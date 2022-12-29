package com.hcl.controller;

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
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService uService;
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpSession session)
	{
		session.invalidate();
		return new ResponseEntity<>("Logout Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getUsers()
	{
		List<UserDTO> users=uService.getAllUser();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> adminLogin(@RequestBody UserLoginDTO userLoginDTO){
		UserDTO userDTO=uService.getUserDetails(userLoginDTO);
		System.out.println(userDTO);
		return new ResponseEntity<>("Authentication Successful",HttpStatus.OK);
	}
	
	/*@PostMapping("/users")
	
	@PutMapping("/users/{id}")
	
	@DeleteMapping("/users/{id}")*/

}
