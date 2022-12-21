package com.gl.service;

import com.gl.dto.UserDTO;

public interface UserService 
{

	public UserDTO addNewUser(UserDTO u);

	public UserDTO authenticate(Integer id, String password);
	
}
