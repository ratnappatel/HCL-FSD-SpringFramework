package com.gl.service;

import java.util.List;

import com.gl.dto.StudentDTO;
import com.gl.exception.StudentException;

public interface StudentService {
	public List<StudentDTO> getAllStudent();
	public StudentDTO getStudentById(int id) throws StudentException;

}
