package com.amigoscode.testing.customer;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

import java.util.Optional;
import java.util.UUID;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

class CustomerRegistrationServiceTest {

	// @Mock
	private CustomerRepository customerRepository = mock(CustomerRepository.class);
	private CustomerRegistrationService underTest;

	@Captor
	private ArgumentCaptor<Customer> customerArgumentCaptor;

	@BeforeEach
	void setUp() throws Exception {
		// MockitoAnnotations.initMocks(this);
		underTest = new CustomerRegistrationService(customerRepository);
	}

	@Test
	void itShouldSaveNewCustomer() {
		// Given a customer with phone Number
		UUID id = UUID.randomUUID();
		String phoneNumber = "000000";
		Customer customer = new Customer(id, "Prashant", phoneNumber);

		// ... a request
		CustomerRegistrationRequest request = new CustomerRegistrationRequest(customer);

		// ... No Customer with phone number passed
		given(customerRepository.selectCustomerByPhoneNumber(phoneNumber)).willReturn(Optional.empty());
		
		// Mocking save method behavior
	  //  doNothing().when(customerRepository).save(customer); // Assuming save does nothing or void return

		// When
		underTest.registerNewCustomer(request);

		// Then
		then(customerRepository).should().save(customerArgumentCaptor.capture());
		Customer customerArgumentCaptorValue = customerArgumentCaptor.getValue();
		Assertions.assertThat(customerArgumentCaptorValue).isEqualTo(customer);

	}

}
