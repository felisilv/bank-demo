package com.felisilv.bank.customer.utils;

import com.felisilv.bank.customer.models.Customer;
import com.felisilv.bank.customer.models.CustomerDTO;

public class CustomerUtils {

  private static final String FIRST_NAME = "John";
  private static final String LAST_NAME = "Doe";

  private CustomerUtils() {
  }

  public static CustomerDTO defaultCustomerDTO() {
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setFirstName(FIRST_NAME);
    customerDTO.setLastName(LAST_NAME);

    return customerDTO;
  }

  public static Customer defaultCustomer() {
    Customer customer = new Customer();
    customer.setFirstName(FIRST_NAME);
    customer.setLastName(LAST_NAME);

    return customer;
  }
}
