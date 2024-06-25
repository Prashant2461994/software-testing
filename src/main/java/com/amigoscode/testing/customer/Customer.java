package com.amigoscode.testing.customer;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;




@Entity
public class Customer {
	
	public Customer(UUID id, String name, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public Customer() {
		
	}
	
	@Id
	private UUID id;
	

	
	@NotNull(message = "name cannot be null")
	@Column(nullable = false, length = 255)
	private String name;
	
  
	@NotNull(message = "Phone number cannot be null")
	@Column(nullable = false, length = 11)
	private String phoneNumber;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	
	
	
}
