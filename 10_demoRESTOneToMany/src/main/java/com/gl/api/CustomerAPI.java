package com.gl.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.dto.CardDTO;
import com.gl.dto.CustomerDTO;
import com.gl.exception.GLBankException;
import com.gl.service.CardCustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerAPI {

	@Autowired
	CardCustomerService cardCustomerService;
	@PostMapping("/")
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
	
	@PutMapping("/{customerID}")
	public ResponseEntity<String> issueCardToCustomer(@PathVariable Integer customerID,@RequestBody CardDTO card)throws GLBankException
	{
		cardCustomerService.issueCardToExistingCustomer(customerID, card);
		return new ResponseEntity<>("Cards Issued Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/{customerID}")
	public ResponseEntity<String> deleteCustomerDetails(@PathVariable Integer customerID) throws GLBankException
	{
		cardCustomerService.deleteCustomer(customerID);
		return new ResponseEntity<>("Customer Detail Removed Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/{customerID}/cards")
	public ResponseEntity<String> deleteCardOfCustomer(@PathVariable Integer customerID,@RequestBody List<Integer> cards) throws GLBankException
	{
		cardCustomerService.deleteCardOfExistingCustomer(customerID, cards);
		return new ResponseEntity<>("Cards deleted for Customer Successfully",HttpStatus.OK);
	}
	
	
}









