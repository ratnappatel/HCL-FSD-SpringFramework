package com.hcl.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee e=new Employee();
		e.setId(rs.getInt("id"));
		e.setName(rs.getString("name"));
		e.setSalary(rs.getDouble("salary"));
		e.setDept(rs.getInt("dept"));
		return e;
	}

}
