package com.hcl.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dto.UserDTO;
import com.hcl.dto.UserLoginDTO;
import com.hcl.entity.User;
import com.hcl.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDTO getUserDetails(UserLoginDTO userDTO) {
		User user=repo.findByNameAndPassword(userDTO.getName(), userDTO.getPassword());
		System.out.println(user);
		return this.getUserDTO(user);
	}

	@Override
	public List<UserDTO> getAllUser() {
		Iterable<User> itr=repo.findAll();
		List<UserDTO> users=new ArrayList<UserDTO>();
		
		itr.forEach(user->
			users.add(this.getUserDTO(user))
				);
		return users;
	}
	
	public UserDTO getUserDTO(User user)
	{
		UserDTO userDTO=new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setType(user.getType());
		
		return userDTO;
	}
	
	public User getUserEntity(UserDTO userDTO)
	{
		User user=new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setType(userDTO.getType());
		
		return user;
	}

}
