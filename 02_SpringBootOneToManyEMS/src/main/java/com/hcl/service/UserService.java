package com.hcl.service;

import java.util.List;

import com.hcl.dto.UserDTO;
import com.hcl.dto.UserLoginDTO;

public interface UserService {
	
	public UserDTO getUserDetails(UserLoginDTO userDTO);
	public List<UserDTO> getAllUser();

}
