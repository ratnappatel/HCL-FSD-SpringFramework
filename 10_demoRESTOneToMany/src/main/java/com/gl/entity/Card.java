package com.gl.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
	
	@Id
	private Integer cardId;
	
	private String cardNumber;
	
	private LocalDate expiryDate;
	
	
	
}
