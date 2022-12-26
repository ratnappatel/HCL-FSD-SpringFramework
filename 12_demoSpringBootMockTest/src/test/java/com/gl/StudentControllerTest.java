package com.gl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gl.controller.StudentController;
import com.gl.dto.StudentDTO;
import com.gl.exception.StudentException;
import com.gl.service.StudentService;

@SpringBootTest(classes= {StudentControllerTest.class})
public class StudentControllerTest {
	
	@Mock
	StudentService service;
	
	@InjectMocks
	StudentController controller;
	
	List<StudentDTO> students;
	
	StudentDTO student;
	
	@Test
	public void test_findById() throws StudentException
	{
		int id=102;
		StudentDTO student=new StudentDTO(102,"Uttam","EEE");
		
		when(service.getStudentById(id)).thenReturn(student);
		
		ResponseEntity<StudentDTO> rs=controller.getStudentById(id);
		assertEquals(HttpStatus.OK,rs.getStatusCode());
		assertEquals(id,rs.getBody().getId());
		
	}
	
	@Test
	public void test_getAllStudent()
	{
		students=new ArrayList<StudentDTO>();
		students.add(new StudentDTO(109, "Neel", "CS"));
		students.add(new StudentDTO(192, "Gargesh", "ICE"));
		
		when(service.getAllStudent()).thenReturn(students);
		
		ResponseEntity<List<StudentDTO>> rs=controller.getAll();
		assertEquals(HttpStatus.OK,rs.getStatusCode());
		
	}
	
	

}
