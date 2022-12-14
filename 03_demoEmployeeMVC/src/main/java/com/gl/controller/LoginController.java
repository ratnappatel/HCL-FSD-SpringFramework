package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.dao.EmployeeDAO;
import com.gl.dao.UserDAO;
import com.gl.pojo.Employee;
import com.gl.pojo.User;

@Controller
public class LoginController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	EmployeeDAO empDAO;
	
	@GetMapping("/")
	public String loginForm()
	{
		return "login";
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam String id,@RequestParam String password) 
	{
		ModelAndView mv=new ModelAndView();
		User user=userDAO.getUser(id, password);
		System.out.println(user);
		if(user!=null)
		{
			System.out.println("In if");
			List<Employee> emps=empDAO.getAllEmployee();
			mv.addObject("user", user);
			mv.addObject("emps", emps);
			mv.setViewName("employeesList");
		}
		else
		{
			System.out.println("In else");
			mv.setViewName("error");
		}
		return mv;
	}

}
