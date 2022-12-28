package com.hcl.service;

import java.util.List;

import com.hcl.entity.Department;
import com.hcl.entity.Employee;
import com.hcl.exception.EMSException;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	public Department getDepartment(int id) throws EMSException;
	

}
