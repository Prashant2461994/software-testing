package com.amigoscode.testing.customer;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerRegistrationRequest {

	private final Customer customer;

	public CustomerRegistrationRequest(@Valid @JsonProperty("customer") Customer customer) {
		super();
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	@Override
	public String toString() {
		return "CustomerRegistrationRequest [customer=" + customer + "]";
	}
	
	
	
	
}
