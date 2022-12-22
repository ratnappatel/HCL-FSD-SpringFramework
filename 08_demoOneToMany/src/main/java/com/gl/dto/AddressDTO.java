package com.gl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//loan
public class AddressDTO {
	
	private int id;
	private String street;
	private String city;

}
