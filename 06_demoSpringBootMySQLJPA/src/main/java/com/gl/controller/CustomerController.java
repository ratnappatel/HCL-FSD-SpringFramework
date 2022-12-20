package com.gl.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.entity.Customer;
import com.gl.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/")
	public String welcome()
	{
		return "index";
	}
	
	@GetMapping("/find")
	public ModelAndView getCustomer(@RequestParam Integer id)
	{
		Customer c=service.getCustomerDetails(id);
		ModelAndView mv=new ModelAndView("displayDetails");
		mv.addObject("cust", c);
		return mv;
	}
	
	@GetMapping ("/addCustomer")
	public String addCustomerForm()
	{
		
		return "addCustomer";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestParam String name, @RequestParam String email, @RequestParam String dateOfBirth)
	{
		Date d = Date.valueOf(dateOfBirth);
		Customer c=new Customer();
		c.setName(name);
		c.setEmail(email);
		c.setDateOfBirth(d);
		service.addCustomer(c);
		return "index";
	}

}











