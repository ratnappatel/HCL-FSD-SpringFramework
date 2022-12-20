package com.gl.repository;

import com.gl.entity.Customer;

public interface CustomerRepository {
	
	public void addCustomer(Customer c);
	public Customer getCustomer(int id);

}
