package com.gl.dao;

import org.hibernate.sql.Update;

import com.gl.entity.Student;

public interface StudentDAO {
	
	public Student getStudent(int id);
	//For DML operation to DB we have mark our DaoImpl class as @Transactional 
	public String addStudent(Student s);
	public Student updateStudent(Student s);
	public String deleteStudent(int id);

}
