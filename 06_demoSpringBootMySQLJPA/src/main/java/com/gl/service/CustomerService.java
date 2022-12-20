package com.gl.service;

import com.gl.entity.Customer;

public interface CustomerService {
	
	public Customer getCustomerDetails(int id);
	public void addCustomer(Customer c);

}
