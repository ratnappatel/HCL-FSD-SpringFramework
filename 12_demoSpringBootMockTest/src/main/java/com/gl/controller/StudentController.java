package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.dto.StudentDTO;
import com.gl.exception.StudentException;
import com.gl.service.StudentService;

@RestController

public class StudentController {
	
	@Autowired 
	StudentService service;
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentDTO>> getAll()
	{
		List<StudentDTO> students=service.getAllStudent();
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Integer id) throws StudentException
	{
		StudentDTO s=service.getStudentById(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	@PostMapping("/students")
	public ResponseEntity<StudentDTO> addNewStudent(@RequestBody StudentDTO studentDTO)
	{
		StudentDTO s=service.addStudent(studentDTO);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable Integer id,@RequestBody StudentDTO studentDTO) throws StudentException
	{
		studentDTO=service.updateStudent(id, studentDTO);
		return new ResponseEntity<>(studentDTO,HttpStatus.OK);
	}
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) throws StudentException
	{
		String s=service.deleteStudent(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}

}
