package com.hcl.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByNameAndPassword(String name,String password);
	

}
