package com.gl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dto.UserDTO;
import com.gl.entity.User;
import com.gl.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository uRepo;
	
	@Override
	public UserDTO addNewUser(UserDTO u) {
		
		u.setType("U");
		User user=uRepo.save(this.getUserEntity(u));
		return this.getUserDTO(user);
	}

	@Override
	public UserDTO authenticate(Integer id, String password) {
		User u=uRepo.findByIdAndPassword(id,password);
		return this.getUserDTO(u);
	}
	
	// Utility Methods help in conversion from DTO --> Entity and vice-versa
	
	public UserDTO getUserDTO(User userEntity)
	{
		UserDTO userDTO=new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setName(userEntity.getName());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setType(userEntity.getType());
		
		return userDTO;
	}
	
	public User getUserEntity(UserDTO userDTO)
	{
		User userEntity=new User();
		userEntity.setId(userDTO.getId());
		userEntity.setName(userDTO.getName());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setType(userDTO.getType());
		
		return userEntity;
	}
	
}
