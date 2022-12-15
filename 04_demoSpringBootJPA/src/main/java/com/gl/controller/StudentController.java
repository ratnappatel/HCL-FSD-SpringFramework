package com.gl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.dao.StudentDAO;
import com.gl.entity.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentDAO dao;
	
	@GetMapping("/find")
	public ModelAndView getStudent(@RequestParam Integer id)
	{
		ModelAndView mv=new ModelAndView("studentDetails");
		Student s=dao.getStudent(id);
		mv.addObject("s", s);
		return mv;
	}
	
	@GetMapping("/")
	public String findStudent()
	{
		return "find";
	}

	@GetMapping("/add")
	public String addStudent()
	{
		return "addStudent";
	}
	
	@PostMapping("/add")
	public String addStudentToDB(@RequestParam Integer id,@RequestParam String name,@RequestParam String stream)
	{
		Student s=new Student(id,name,stream);
		return dao.addStudent(s);
	}

	@GetMapping("/update")
	public String updateStudentForm()
	{
		return "updateStudent";
	}
	
	@PostMapping("/update")
	public ModelAndView updateStudent(@RequestParam Integer id,@RequestParam String name,@RequestParam String stream)
	{
		Student s=new Student(id,name,stream);
		s=dao.updateStudent(s);
		ModelAndView mv=new ModelAndView("studentDetails");
		mv.addObject("s",s);
		return mv;
		
	}
	
	@GetMapping("/delete")
	public String deleteStudentForm()
	{
		return "delete";
	}
	
	@PostMapping("/delete")
	public String deleteStudent(@RequestParam Integer id)
	{
		return dao.deleteStudent(id);
		
	}
}
