package com.hcl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.hcl.entity.Department;
import com.hcl.entity.Employee;
import com.hcl.exception.EMSException;
import com.hcl.service.EmployeeService;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application implements CommandLineRunner{

	@Autowired
	EmployeeService service;
	
	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	public Docket postsApi()
	{
			return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()).select().build();
	}
	
	private ApiInfo apiInfo()
	{
			return new ApiInfoBuilder().title("Documenting API")
						.description("Documentation For Ease of Developer")
						.termsOfServiceUrl("https://greatlearning.com/")
						.licenseUrl("ratnabpatel@gmail.com").version("2.0").build();
	}


	//Desktop Client
	@Override
	public void run(String... args) throws Exception {
		//this.getAllEmployee();
		//this.getDepartmentDetails();
		
	}
	public void getAllEmployee()
	{
		List<Employee> emps=service.getAllEmployee();
		System.out.println(emps);
		
	}

	public void getDepartmentDetails()
	{
		try 
		{
			Department d=service.getDepartment(10);
			System.out.println(d);
			
		} catch (EMSException e) {
			System.out.println(env.getProperty(e.getMessage()));
		}
	}
}
