package com.gl.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.gl.entity.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
	
	// To perform any CRUD operation using JPA we need EntityManager object
	@PersistenceContext
	EntityManager em;

	@Override
	public void addCustomer(Customer c) {
		
		try {
			em.persist(c);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Customer getCustomer(int id) {
		Customer c=null;
		c=em.find(Customer.class, id);
		return c;
	}

}
