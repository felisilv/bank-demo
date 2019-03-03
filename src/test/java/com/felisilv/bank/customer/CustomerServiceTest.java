package com.felisilv.bank.customer;

import com.felisilv.bank.customer.models.Customer;
import com.felisilv.bank.customer.utils.CustomerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@Import(ValidationAutoConfiguration.class)
@ContextConfiguration(classes = CustomerService.class)
public class CustomerServiceTest {

  @MockBean
  private CustomerRepository customerRepositoryMock;

  @Autowired
  private CustomerService customerService;

  @Test(expected = ConstraintViolationException.class)
  public void shouldRejectCustomerWithNullFirstName() {
    Customer customer = CustomerUtils.defaultCustomer();
    customer.setFirstName(null);

    customerService.createCustomer(customer);

    verify(customerRepositoryMock, times(0)).save(any(Customer.class));
  }

  @Test(expected = ConstraintViolationException.class)
  public void shouldRejectCustomerWithNullLastName() {
    Customer customer = CustomerUtils.defaultCustomer();
    customer.setLastName(null);

    customerService.createCustomer(customer);

    verify(customerRepositoryMock, times(0)).save(any(Customer.class));
  }

  @Test
  public void shouldSaveToRepositoryOnCreateCustomerRequest() {
    Customer customer = CustomerUtils.defaultCustomer();
    Customer savedCustomer = CustomerUtils.defaultCustomer();
    savedCustomer.setFirstName("saved");
    when(customerRepositoryMock.save(any(Customer.class))).thenReturn(savedCustomer);

    Customer createdCustomer = customerService.createCustomer(customer);

    assertThat(createdCustomer).isNotNull();
    assertThat(createdCustomer).isEqualTo(savedCustomer);
    verify(customerRepositoryMock, times(1)).save(any(Customer.class));
  }

}