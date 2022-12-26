package com.gl.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
