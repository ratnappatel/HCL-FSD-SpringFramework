package com.gl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.gl.repository.CalcRepository;
import com.gl.service.CalcService;

@SpringBootTest
class ApplicationTests {


	@Mock
	CalcRepository calcRepository;
	
	@InjectMocks
	CalcService service;
	
	@Test
	public void testFindAvergae()
	{
		when(calcRepository.findAll()).thenReturn(new int[] {10,10,10,10,10});
		assertEquals(10.0f,service.findTheAvergae());
	}
	
	@Test
	public void testFindAvergae_OneValue()
	{
		when(calcRepository.findAll()).thenReturn(new int[] {100});
		assertEquals(100.0f,service.findTheAvergae());
	}
	
	@Test
	public void testFindAvergae_NoValue()
	{
		when(calcRepository.findAll()).thenReturn(new int[] {});
		assertEquals(0.0f,service.findTheAvergae());
		ArithmeticException ae=assertThrows(ArithmeticException.class,()->service.findTheAvergae());
		System.out.println(ae.getMessage());
		assertEquals("No Data Found",ae.getMessage());
	}
	
	

}
