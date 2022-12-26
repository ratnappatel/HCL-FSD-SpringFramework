package com.gl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dto.StudentDTO;
import com.gl.entity.Student;
import com.gl.exception.StudentException;
import com.gl.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository repository;

	@Override
	public List<StudentDTO> getAllStudent() {
		Iterable<Student> itr=repository.findAll();
		List<StudentDTO> students=new ArrayList<StudentDTO>();
		itr.forEach(s->{
			StudentDTO studentDTO=this.getStudentDTO(s);
			students.add(studentDTO);
		});
		return students;
	}

	@Override
	public StudentDTO getStudentById(int id) throws StudentException {
		Optional<Student> op=repository.findById(id);
		Student s=op.orElseThrow(()->new StudentException("Student with given id not found"));
		return null;
	}
	public StudentDTO getStudentDTO(Student entity)
	{
		StudentDTO studentDTO=new StudentDTO();
		studentDTO.setId(entity.getId());
		studentDTO.setName(entity.getName());
		studentDTO.setStream(entity.getStream());
		return studentDTO;
	}
	
	public Student getStudentEntity(StudentDTO studentDTO)
	{
		Student entity=new Student();
		entity.setId(studentDTO.getId());
		entity.setName(studentDTO.getName());
		entity.setStream(studentDTO.getStream());
		return entity;
	}

	@Override
	public StudentDTO addStudent(StudentDTO studentDTO) {
		Student s=this.getStudentEntity(studentDTO);
		s=repository.save(s);
		return this.getStudentDTO(s);
	}

	@Override
	public StudentDTO updateStudent(int id, StudentDTO studentDTO) throws StudentException {
		Student newStudent=this.getStudentEntity(studentDTO);
		Optional<Student> op=repository.findById(id);
		Student oldStudent=op.orElseThrow(()->new StudentException("Student Does Not Exists"));
		oldStudent.setId(id);
		oldStudent.setName(newStudent.getName());
		oldStudent.setStream(newStudent.getStream());
		repository.save(oldStudent);
		return this.getStudentDTO(oldStudent);
	}

	@Override
	public String deleteStudent(int id) throws StudentException {
		Optional<Student> op=repository.findById(id);
		Student s=op.orElseThrow(()->new StudentException("Student Does Not Exists"));
		repository.delete(s);
		return "Deleted";
	}
	
	
	

}
