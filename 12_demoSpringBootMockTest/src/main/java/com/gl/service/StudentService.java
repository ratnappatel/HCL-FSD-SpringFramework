package com.gl.service;

import java.util.List;

import com.gl.dto.StudentDTO;
import com.gl.exception.StudentException;

public interface StudentService {
	public List<StudentDTO> getAllStudent();
	public StudentDTO getStudentById(int id) throws StudentException;
	public StudentDTO addStudent(StudentDTO studentDTO);
	public StudentDTO updateStudent(int id,StudentDTO studentDTO)throws StudentException;
	public String deleteStudent(int id)throws StudentException;

}
