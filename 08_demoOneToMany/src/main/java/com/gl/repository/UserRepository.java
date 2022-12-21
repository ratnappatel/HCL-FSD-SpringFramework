package com.gl.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.entity.User;

public interface UserRepository  extends CrudRepository<User , Integer>{

	// This method will generated dynamic query during runtime 
	public User findByIdAndPassword(int id,String password);
}
