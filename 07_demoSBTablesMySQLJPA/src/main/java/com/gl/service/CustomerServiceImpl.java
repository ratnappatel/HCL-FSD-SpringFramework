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
	public Customer updateCustomer(int id, Customer updatedCustomer) {
		Optional<Customer> op=repo.findById(id);
		Customer oldCustomer=null;
		if(op.isPresent())
		{
			oldCustomer=op.get();
			oldCustomer.setName(updatedCustomer.getName());
			oldCustomer.setEmail(updatedCustomer.getEmail());
			oldCustomer.setDateOfBirth(updatedCustomer.getDateOfBirth());
			
			oldCustomer.setLoan(updatedCustomer.getLoan());
			oldCustomer=repo.save(oldCustomer);
		}
		return oldCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		Optional<Customer> op=repo.findById(id);
		if(op.isPresent())
			repo.delete(op.get());
		
	}

}
