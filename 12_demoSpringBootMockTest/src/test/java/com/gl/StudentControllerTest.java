package com.gl;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gl.dto.StudentDTO;
import com.gl.service.StudentService;

@WebMvcTest
public class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	StudentService service;
	
	private StudentDTO s1;
	private StudentDTO s2;
	
	List<StudentDTO> students=new ArrayList<StudentDTO>();
	
	@BeforeEach
	void init()
	{
		s1=new StudentDTO(110,"Uttam","IIT");
		s2=new StudentDTO(120,"Pinakin","Onco");
		
	}
	@Test
	void addStudent()throws Exception
	{
		when(service.addStudent(any(StudentDTO.class))).thenReturn(s1);

		this.mockMvc
				.perform(post("/students").contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(s1)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.name", is(s1.getName())))
				.andExpect(jsonPath("$.id", is(s1.getId())))
				.andExpect(jsonPath("$.stream", is(s1.getStream().toString())));
			
	}
	
	
	@Test
	void shouldFetchOneStudentById() throws Exception {
		
		when(service.getStudentById(anyInt())).thenReturn(s1);
		
		this.mockMvc.perform(get("/students/{id}", 110))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is(s1.getName())))
			.andExpect(jsonPath("$.stream", is(s1.getStream())));
	}
	
	@Test
	void shouldFetchAllStudents() throws Exception {
		
		students.add(s1);
		students.add(s2);
		
		when(service.getAllStudent()).thenReturn(students);
		
		this.mockMvc.perform(get("/students"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.size()", is(4)));
	}
	
	@Test
	void shouldUpdateStudent() throws Exception {
		
		StudentDTO s=new StudentDTO(110,"newName","newStream");
		when(service.updateStudent(anyInt(), any(StudentDTO.class))).thenReturn(s1);		
		this.mockMvc.perform(put("/students/{id}", 110)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(s)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is(s1.getName())))
		.andExpect(jsonPath("$.stream", is(s1.getStream())));
	}
	
	@Test
	void shouldDeleteStudent() throws Exception {
		
		when(service.deleteStudent(anyInt())).thenReturn("Deleted");
		
		this.mockMvc.perform(delete("/students/{id}", 110))
			.andExpect(status().isOk());
			
	}
	

}
