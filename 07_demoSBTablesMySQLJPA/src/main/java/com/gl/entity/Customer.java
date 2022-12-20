package com.gl.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private Date dateOfBirth;
	
	//Trying to implement One-To-One relation
	@OneToOne(cascade=CascadeType.ALL)
	// Joing column annotation instructs spring boot to create foreign key column with name
	@JoinColumn(name="loan_id" ,unique=true)
	private Loan loan;

}
