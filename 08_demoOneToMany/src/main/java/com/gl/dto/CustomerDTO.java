package com.gl.dto;

import java.sql.Date;
import java.util.List;

import com.gl.entity.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	
	private int id;
	private Long mobile;
	private String email;
	private Date dateOfBirth;
	private List<Address> addresses;
	private UserDTO user;

}
