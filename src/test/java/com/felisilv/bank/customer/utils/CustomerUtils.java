package com.felisilv.bank.customer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.felisilv.bank.customer.models.Customer;
import com.felisilv.bank.customer.models.CustomerRequest;
import com.felisilv.bank.customer.models.CustomerResponse;

public class CustomerUtils {

  private static final String FIRST_NAME = "John";
  private static final String LAST_NAME = "Doe";
  private static final long CUSTOMER_ID = 1L;

  private static final ObjectMapper MAPPER = new ObjectMapper();

  private CustomerUtils() {
  }

  public static CustomerRequest defaultCustomerRequest() {
    CustomerRequest customerRequest = new CustomerRequest();
    customerRequest.setFirstName(FIRST_NAME);
    customerRequest.setLastName(LAST_NAME);

    return customerRequest;
  }

  public static Customer defaultCustomer() {
    Customer customer = new Customer();
    customer.setFirstName(FIRST_NAME);
    customer.setLastName(LAST_NAME);
    customer.setId(CUSTOMER_ID);

    return customer;
  }

  public static String getCustomerResponseJson() throws JsonProcessingException {
    CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setCustomerId(CUSTOMER_ID);

    return MAPPER.writeValueAsString(customerResponse);
  }
}
