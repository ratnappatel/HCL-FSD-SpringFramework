package com.hcl.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages="com.hcl")
@PropertySource("classpath:database.properties")
public class SpringConfig {
	
	// To read from properties file use Environment class from Spring API
	@Autowired
	Environment env;
	
	@Bean
	DataSource dataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("driver"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("user"));
		ds.setPassword(env.getProperty("password"));
		
		return ds;
	}

}
