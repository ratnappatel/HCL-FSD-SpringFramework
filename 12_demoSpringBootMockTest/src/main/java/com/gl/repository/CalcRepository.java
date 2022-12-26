package com.gl.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalcRepository {
	
	public int[] findAll()
	{
		return new int[] {10,20,30,40,50};
	}

}
