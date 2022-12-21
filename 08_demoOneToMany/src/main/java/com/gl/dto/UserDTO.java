package com.gl.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Data Transfer Object

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private int id;
	private String name;
	private String password;
	private String type;
	

}
