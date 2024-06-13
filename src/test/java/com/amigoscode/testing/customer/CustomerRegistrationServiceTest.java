package com.amigoscode.testing.customer;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CustomerRegistrationServiceTest {

	//@Mock
	private CustomerRepository customerRepository = mock(CustomerRepository.class);
	private  CustomerRegistrationService underTest;
	
	@BeforeEach
	 void setUp() throws Exception {
	//	MockitoAnnotations.initMocks(this);
		underTest = new CustomerRegistrationService(null);
	}

	
	
}
