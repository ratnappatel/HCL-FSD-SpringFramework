package com.gl.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// Mapping uri with respective jsp view 
@Controller
public class LoginController {
	
	Logger logger=LoggerFactory.getLogger(LoginController.class);
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String doLogin()
	{
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView welcomeUser(@RequestParam String uname,@RequestParam String password)
	{
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("uname", uname);
		mv.setViewName("welcome");
		logger.info("User logged in  ");
		return mv;
	}

}
