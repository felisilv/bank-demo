package com.felisilv.bank.customer;

import com.felisilv.bank.customer.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@Validated
@RequiredArgsConstructor
class CustomerService {
  private final CustomerRepository customerRepository;

  Customer createCustomer(@Valid Customer customer) {
    return customerRepository.save(customer);
  }

}
