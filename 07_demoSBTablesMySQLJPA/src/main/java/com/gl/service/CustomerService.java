package com.gl.service;

import java.util.List;

import com.gl.entity.Customer;
import com.gl.exception.CustomerException;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer);
	public Customer getCustomer(int id) throws CustomerException;
	public List<Customer> getAllCustomer();
	public Customer updateCustomer(int id,Customer customer);
	public void deleteCustomer(int id);

}
