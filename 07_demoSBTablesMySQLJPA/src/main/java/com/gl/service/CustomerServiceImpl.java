package com.gl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Customer;
import com.gl.exception.CustomerException;
import com.gl.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository repo;
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		return repo.save(customer);
	}

	@Override
	public Customer getCustomer(int id) throws CustomerException{
		Optional<Customer> op=repo.findById(id);
		if(op.isPresent())
			return op.get();
		else
			throw new CustomerException("Customer with id : "+id+" Not Found");
	}

	@Override
	public List<Customer> getAllCustomer() {
		Iterable<Customer> itr=repo.findAll();
		List<Customer> list=new ArrayList<Customer>();
		
		itr.forEach(c->list.add(c));
		return list;
	}

	@Override
	public Customer updateCustomer(int id, Customer customer) {
		
		return null;
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		
	}

}
