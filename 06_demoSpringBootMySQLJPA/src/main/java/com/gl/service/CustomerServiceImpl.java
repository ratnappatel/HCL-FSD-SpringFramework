package com.gl.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Customer;
import com.gl.repository.CustomerRepository;

//Service class needs an object of repository
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repository;
	
	@Override
	public Customer getCustomerDetails(int id) {
	
		return repository.getCustomer(id);
	}

	@Override
	public void addCustomer(Customer c) {
		repository.addCustomer(c);		
	}
	
}
