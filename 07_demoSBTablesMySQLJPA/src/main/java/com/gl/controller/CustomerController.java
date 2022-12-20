package com.gl.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.entity.Customer;
import com.gl.entity.Loan;
import com.gl.exception.CustomerException;
import com.gl.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@GetMapping("/")
	public ModelAndView welcome()
	{
		List<Customer> list=service.getAllCustomer();
		ModelAndView mv=new ModelAndView("customerList");
		mv.addObject("customers", list);
		return mv;
	}
	
	@GetMapping("/find")
	public ModelAndView getCustomer(@RequestParam Integer id)
	{
		Customer c=null;
		ModelAndView mv=new ModelAndView();
		try 
		{
			c = service.getCustomer(id);
			mv=new ModelAndView("displayDetails");
			mv.addObject("cust", c);
		} catch (CustomerException e) {
			mv.setViewName("error");
			mv.addObject("e", e);
		}
		return mv;
	}
	
	@GetMapping ("/addCustomer")
	public String addCustomerForm()
	{
		
		return "addCustomer";
	}
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestParam String name, @RequestParam String email, @RequestParam String dateOfBirth,
			@RequestParam String title,@RequestParam String amount)
	{
		Date d = Date.valueOf(dateOfBirth);
		
		Loan loan=new Loan();
		Customer c=new Customer();
		c.setLoan(loan);
		
		c.setName(name);
		c.setEmail(email);
		c.setDateOfBirth(d);
		
		c.getLoan().setTitle(title);
		c.getLoan().setAmount(Float.valueOf(amount));
		service.addCustomer(c);
		return "index";
	}

}











