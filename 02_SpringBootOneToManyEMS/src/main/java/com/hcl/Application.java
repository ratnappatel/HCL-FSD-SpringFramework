package com.hcl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.hcl.entity.Department;
import com.hcl.entity.Employee;
import com.hcl.exception.EMSException;
import com.hcl.service.EmployeeService;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	EmployeeService service;
	
	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	//Desktop Client
	@Override
	public void run(String... args) throws Exception {
		//this.getAllEmployee();
		//this.getDepartmentDetails();
		
	}
	public void getAllEmployee()
	{
		List<Employee> emps=service.getAllEmployee();
		System.out.println(emps);
		
	}

	public void getDepartmentDetails()
	{
		try 
		{
			Department d=service.getDepartment(10);
			System.out.println(d);
			
		} catch (EMSException e) {
			System.out.println(env.getProperty(e.getMessage()));
		}
	}
}
