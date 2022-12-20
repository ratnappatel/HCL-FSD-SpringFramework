package com.gl.entity;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	//Every Single Entity class must have atleast one primary-key column/field
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; // created as id column as Primary key
	private String name;
	private String email;
	private Date dateOfBirth;
	

}