package com.gl.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.gl.pojo.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	ArrayList<Employee> emps=new ArrayList<Employee>();
	public EmployeeDAOImpl() {
		emps.add(new Employee(101,"A1",345.456,12));
		emps.add(new Employee(102,"A2",345.456,12));
		emps.add(new Employee(103,"A3",345.456,12));
		emps.add(new Employee(104,"A4",345.456,12));
		emps.add(new Employee(105,"A5",345.456,12));
	}
	
	public List<Employee> getAllEmployee()
	{
		return emps;
	}

}
