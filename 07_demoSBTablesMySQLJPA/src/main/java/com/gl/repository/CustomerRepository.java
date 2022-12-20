package com.gl.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
	
	
	

}
