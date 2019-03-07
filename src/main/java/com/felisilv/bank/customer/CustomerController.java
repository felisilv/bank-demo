package com.felisilv.bank.customer;

import com.felisilv.bank.customer.models.Customer;
import com.felisilv.bank.customer.models.CustomerRequest;
import com.felisilv.bank.customer.models.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class CustomerController {

  private final CustomerService customerService;

  @PostMapping("customer")
  CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest) {
    Customer customer = new Customer(customerRequest);
    Long customerId = customerService.createCustomer(customer).getId();
    CustomerResponse customerResponse = new CustomerResponse();
    customerResponse.setCustomerId(customerId);

    return customerResponse;
  }

}
