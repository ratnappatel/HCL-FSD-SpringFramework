package com.gl.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.dto.CardDTO;
import com.gl.dto.CustomerDTO;
import com.gl.entity.Card;
import com.gl.entity.Customer;
import com.gl.exception.GLBankException;
import com.gl.repository.CardRepository;
import com.gl.repository.CustomerRepository;

@Service(value = "cardCustomerService")
@Transactional
public class CardCustomerServiceImpl implements CardCustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	// Fetch customerDTO details
	/**
	 This method calls findById method of customerRepository passing customerId received in parameter
	
	 @param Integer customerId
	 @return CustomerDTO object returned from findById method of customerRepository
	 @throws Service.CUSTOMER_NOT_FOUND exception if findById method of customerRepository returns null
	 */
	@Override
	public CustomerDTO getCustomerDetails(Integer customerId) throws GLBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(()->new GLBankException("Service.CUSTOMER_NOT_FOUND"));
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setEmailId(customer.getEmailId());
		customerDTO.setName(customer.getName());
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setDateOfBirth(customer.getDateOfBirth());
		
		List<Card> cards = customer.getCards();
		List<CardDTO> cardDTOs = new LinkedList<>();		
		
		if (!cards.isEmpty()) {
			cardDTOs = cards.stream()
					.map(c->new CardDTO(c.getCardId(),c.getCardNumber(),c.getExpiryDate()))
					.collect(Collectors.toList());
		}
		customerDTO.setCards(cardDTOs);
		return customerDTO;
	}

	/**
	 This method calls save method of customerRepository passing Customer entity populated using customerDTO object received in parameter
	 @param CustomerDTO object 
	 @return Integer customerId after calling save method of customerRepository
	 */
	@Override
	public Integer addCustomer(CustomerDTO customerDTO) throws GLBankException {
		Customer customer = new Customer();
		customer.setName(customerDTO.getName());
		customer.setEmailId(customerDTO.getEmailId());
		customer.setDateOfBirth(customerDTO.getDateOfBirth());
		List<CardDTO> cardDTOs = customerDTO.getCards();
		List<Card> cards;
		
		cards = cardDTOs.stream()
				.map(c->new Card(c.getCardId(),c.getCardNumber(),c.getExpiryDate()))
				.collect(Collectors.toList());
		customer.setCards(cards);
		
		customerRepository.save(customer);
		return customer.getCustomerId();
		
	}
	/**
	 This method first calls findById method of customerRepository passing customerId received in parameter
	 ,then sets card object received in parameter to the customer entity.
	 @param Integer customerId, CardDTO object
	 @throws Service.CUSTOMER_NOT_FOUND exception if findById method of customerRepository returns null
	 */
	@Override
	public void issueCardToExistingCustomer(Integer customerId, CardDTO cardDTO) throws GLBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(()->new GLBankException("Service.CUSTOMER_NOT_FOUND"));
		Card card = new Card();
		card.setCardId(cardDTO.getCardId());
		card.setCardNumber(cardDTO.getCardNumber());
		card.setExpiryDate(cardDTO.getExpiryDate());
		List<Card> c = customer.getCards();
		c.add(card);
		customer.setCards(c);
		
	}
	/**
	 This method first calls findById method of customerRepository passing customerId received in parameter
	 ,then calls  delete method of customerRepository passing customerId received in parameter
	 @param Integer customerId
	 @throws Service.CUSTOMER_NOT_FOUND exception if findById method of customerRepository returns null
	 */
	@Override
	public void deleteCustomer(Integer customerId) throws GLBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(()->new GLBankException("Service.CUSTOMER_NOT_FOUND"));
		customerRepository.delete(customer);
	}
	/**
	 This method first calls findById method of customerRepository passing customerId received in parameter
	 ,then calls findById method of cardRepository passing each cardId received in parameter
	 @param Integer customerId, List<Integer> cardIdsToDelete
	 @throws Service.CUSTOMER_NOT_FOUND exception if findById method of customerRepository returns null
	 */
	@Override
	public void deleteCardOfExistingCustomer(Integer customerId, List<Integer> cardIdsToDelete) throws GLBankException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		Customer customer = optional.orElseThrow(()->new GLBankException("Service.CUSTOMER_NOT_FOUND"));
		for (Integer cardId : cardIdsToDelete) {
			Optional<Card> optionalCard = cardRepository.findById(cardId);
			if(optionalCard.isPresent()) {
				customer.getCards().remove(optionalCard.orElse(null));
				cardRepository.deleteById(cardId);
			}			
		}
	}

}
