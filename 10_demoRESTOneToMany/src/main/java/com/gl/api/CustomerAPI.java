package com.gl.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.dto.CustomerDTO;
import com.gl.exception.GLBankException;
import com.gl.service.CardCustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {

	@Autowired
	CardCustomerService cardCustomerService;
	@PostMapping("/add")
	public ResponseEntity<Integer> addCustomer(@RequestBody CustomerDTO customer) throws GLBankException
	{
		int id=cardCustomerService.addCustomer(customer);
		ResponseEntity<Integer> re=new ResponseEntity<>(id,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/{customerID}")
	public ResponseEntity<CustomerDTO> getCustomerDetails(@PathVariable Integer customerID) throws GLBankException
	{
		CustomerDTO customerDTO=cardCustomerService.getCustomerDetails(customerID);
		return new ResponseEntity<>(customerDTO,HttpStatus.OK);
	}
}









