package com.hcl.beans;

import org.springframework.stereotype.Component;

@Component
public class WelcomeBean {
	
	public String greet()
	{
		return "Welcome To Spring..";
	}

}
