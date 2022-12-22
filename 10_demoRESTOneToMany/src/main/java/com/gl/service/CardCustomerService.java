package com.gl.service;

import java.util.List;

import com.gl.dto.CardDTO;
import com.gl.dto.CustomerDTO;
import com.gl.exception.GLBankException;

public interface CardCustomerService {
	
	public CustomerDTO getCustomerDetails(Integer customerId) throws GLBankException;
	public Integer addCustomer(CustomerDTO customerDTO) throws GLBankException;
	public void issueCardToExistingCustomer(Integer customerId, CardDTO cardDTO) throws GLBankException;
	public void deleteCustomer(Integer customerId) throws GLBankException;
	public void deleteCardOfExistingCustomer(Integer customerId, List<Integer> cardIdsToDelete) throws GLBankException;

}
