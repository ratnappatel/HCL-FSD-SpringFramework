package com.gl.dao;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gl.entity.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	Logger logger=LoggerFactory.getLogger(StudentDaoImpl.class);

	@Override
	public Student getStudent(int id) {
		Student s=em.find(Student.class, id);
		return s;
	}

	@Override
	public String addStudent(Student s) {
		try
		{
			em.persist(s);
		} catch (Exception e) {
			logger.error("Could not insert student details."+e.getMessage());
		}
		
		return "success";
	}

	@Override
	public Student updateStudent(Student s) {
		try 
		{
			em.merge(s);
		} catch (Exception e) {
			logger.error("Could not update student details."+e.getMessage());
		}
		s=this.getStudent(s.getId());
		return s;
	}

	@Override
	public String deleteStudent(int id) {
		Student s=this.getStudent(id);
		try 
		{
			em.remove(s);
		} catch (Exception e) {
			logger.error("Could not delete student details."+e.getMessage());
		}
		return "success";
	}
}
