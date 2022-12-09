package com.hcl.dao;

import java.util.List;

import com.hcl.pojo.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(Integer id);
	boolean addEmployee(Employee emp);
	boolean updateEmployee(Employee emp);
	boolean deleteEmployee(int id);
	

}
