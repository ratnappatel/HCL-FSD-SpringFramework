package com.hcl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hcl.beans.WelcomeBean;

@Configuration
public class SpringConfig {
	
	@Bean
	public WelcomeBean welcomeBean()
	{
		return new WelcomeBean();
	}

}
