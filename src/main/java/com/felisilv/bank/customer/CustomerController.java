package com.felisilv.bank.customer;

import com.felisilv.bank.customer.models.Customer;
import com.felisilv.bank.customer.models.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class CustomerController {

  private final CustomerService customerService;

  @PostMapping("customer")
  Long createCustomer(@RequestBody CustomerDTO customerDTO) {
    Customer customer = new Customer(customerDTO);
    return customerService.createCustomer(customer).getId();
  }

}
