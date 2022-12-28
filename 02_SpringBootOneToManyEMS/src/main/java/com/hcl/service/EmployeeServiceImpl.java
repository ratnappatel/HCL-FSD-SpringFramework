package com.hcl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.entity.Department;
import com.hcl.entity.Employee;
import com.hcl.exception.EMSException;
import com.hcl.repository.DepartmentRepository;
import com.hcl.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository eRepo;
	
	@Autowired
	DepartmentRepository dRepo;
	
	@Override
	public List<Employee> getAllEmployee() {

		Iterable<Employee> itr= eRepo.findAll();
		List<Employee>  emps=new ArrayList<Employee>();
		itr.forEach(e->
			emps.add(e));
		return emps;
	}

	@Override
	public Department getDepartment(int id) throws EMSException{
		Optional<Department> op=dRepo.findById(id);
		Department d=op.orElseThrow(()->new EMSException("service.department_not_found"));
		return d;
	}

}
