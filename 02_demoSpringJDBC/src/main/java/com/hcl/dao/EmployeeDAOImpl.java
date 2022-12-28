package com.hcl.dao;

import java.util.List;


import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.hcl.pojo.Employee;
import com.hcl.pojo.EmployeeMapper;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	
	JdbcTemplate template;
	
	public EmployeeDAOImpl(DataSource ds) {
		template=new JdbcTemplate(ds);
	}

	public List<Employee> getAllEmployee() {
		return template.query("select * from employee", new EmployeeMapper());
	}

	public Employee getEmployeeById(Integer id) {
		
		return template.queryForObject("select * from employee where id=?",new Object[] {id} ,new EmployeeMapper());
	}

	public boolean addEmployee(Employee emp) {
		/*
		 * return template.update("insert into employee values(?,?,?,?)"
		 * ,emp.getId(),emp.getName(),emp.getSalary(),emp.getDept())>0;
		 */
		int ra= template.update("insert into employee values(?,?,?,?)"
				,emp.getId(),emp.getName(),emp.getSalary(),emp.getDept());
		if(ra>0)
			return true;
		else
			return false;
	}

	public boolean updateEmployee(Employee emp) {
		return template.update("update employee set name=?, salary=? , dept=? where id=?",emp.getName(),emp.getSalary(),emp.getDept(),emp.getId())>0;
	}

	public boolean deleteEmployee(int id) {		
		return template.update("delete from employee where id=?",id)>0;
	}

}
