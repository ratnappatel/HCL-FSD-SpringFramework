package com.gl.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CardDTO {

	private Integer cardId;
	private String cardNumber;
	private LocalDate expiryDate;
	
	
}
