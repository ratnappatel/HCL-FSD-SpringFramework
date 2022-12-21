package com.gl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.dto.UserDTO;
import com.gl.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/login")
	public ModelAndView loginToPortal()
	{
		return new ModelAndView("login","user",new UserDTO());
	}
	
	
	@GetMapping("/register")
	public ModelAndView registerForm()
	{
		/*UserDTO u=new UserDTO();
		ModelAndView mv=new ModelAndView("register");
		mv.addObject("user", u);
		return mv;*/
		
		return new ModelAndView("register", "user", new UserDTO());
	}
	
	@PostMapping("/register")
	public ModelAndView registerNewUser(@ModelAttribute("user")UserDTO u)
	{
		u=service.addNewUser(u);
		return new ModelAndView("welcome", "user", u);
	}
	
	@PostMapping("/login")
	public ModelAndView loginUser(@ModelAttribute("user")UserDTO u, HttpSession session)
	{
		System.out.println(u);
		ModelAndView mv=null;
		u=service.authenticate(u.getId(),u.getPassword());
		System.out.println(u);
		if(u!=null)
		{
			session.setAttribute("name", u.getName());
			if(u.getType().equals("A"))
				mv=new ModelAndView("customerList","user",u);
			else
				mv=new ModelAndView("customerDetails","user",u);
		}
		return mv;
	}

	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session)
	{
		session.removeAttribute("name");
		return "login";
	}
}
