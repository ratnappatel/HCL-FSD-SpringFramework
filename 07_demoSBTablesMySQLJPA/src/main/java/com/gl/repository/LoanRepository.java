package com.gl.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.entity.Loan;

public interface LoanRepository extends CrudRepository<Loan,Integer> {
	

}
