package com.hcl.repository;

import org.springframework.data.repository.CrudRepository;

import com.hcl.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{

}
