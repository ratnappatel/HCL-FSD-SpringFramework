package com.hcl.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeAspect {
	
	LocalDateTime start;
	@Around("execution(* com.hcl.dao.*.*(..))")
	public boolean methodExecuted()
	{
		System.out.println("Method from DAO package has been called.....@"+LocalDateTime.now());
		return true;
	}
	
	@Before("execution(* com.hcl.dao.*.*(..))")
	public boolean beforeAdvice()
	{
		this.start=LocalDateTime.now();
		System.out.println("Method Started Execution @"+LocalDateTime.now());
		return true;
	}
	
	@After("execution(* com.hcl.dao.*.*(..))")
	public boolean afterAdvice()
	{
		int duration=LocalDateTime.now().getNano()-start.getNano();
		System.out.println("The method took "+duration+" nano seconds to complete it execution");
		return true;
	}
}
