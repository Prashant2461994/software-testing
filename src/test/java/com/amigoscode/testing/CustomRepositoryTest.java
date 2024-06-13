package com.amigoscode.testing;

import java.util.Optional;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;

import com.amigoscode.testing.customer.Customer;
import com.amigoscode.testing.customer.CustomerRepository;

@DataJpaTest
public class CustomRepositoryTest {

	@Autowired
	private CustomerRepository underTest;

	@Test
	void itShouldSelectCustomerByPhoneNumber() {
		// Given
		// When
		// Then
	}

	@Test
	void itShouldSaveCustomer() {
		UUID id = UUID.randomUUID();
		// Given
		Customer customer = new Customer(id, "prashant", "0000");
		// When
		underTest.save(customer);
		// Then

		Optional<Customer> optionalCustomer = underTest.findById(id);

		/*
		 * assertThat(optionalCustomer).isPresent() .hasValueSatisfying(c -> {
		 * assertThat(c.getId()).isEqualTo(id);
		 * assertThat(c.getName()).isEqualTo("prashant");
		 * assertThat(c.getPhoneNumber()).isEqualTo("0000"); });
		 */

		/**** OR ****/

		assertThat(optionalCustomer).isPresent().hasValueSatisfying(c -> {
			assertThat(c).isEqualToComparingFieldByField(customer);
		});

	}

}
