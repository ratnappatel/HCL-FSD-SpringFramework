package com.gl.service;

import org.springframework.stereotype.Service;

import com.gl.repository.CalcRepository;

@Service
public class CalcService {
	
	private CalcRepository calcRepository;
	
	// Injecting Repository as dependency
	// CalcService calc=new CalcService(new CalcRepository());
	public CalcService(CalcRepository calcRepository) {
		super();
		this.calcRepository=calcRepository;
	}
	
	//Business-logic method
	public float findTheAvergae()throws ArithmeticException
	{
		int data[]=calcRepository.findAll();
		float average=0.0f;
		int sum=0;
		if(data.length<1)
			throw new ArithmeticException("No Data Found");
		else
		{
			for(int no:data)
				sum+=no;
		}
		average=sum/data.length;
		return average;
	}

}
