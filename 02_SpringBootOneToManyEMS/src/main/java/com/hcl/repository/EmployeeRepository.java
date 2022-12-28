package com.hcl.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
