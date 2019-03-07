package com.felisilv.bank.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felisilv.bank.customer.models.Customer;
import com.felisilv.bank.customer.models.CustomerRequest;
import com.felisilv.bank.customer.utils.CustomerUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.felisilv.bank.customer.utils.CustomerUtils.defaultCustomer;
import static com.felisilv.bank.customer.utils.CustomerUtils.getCustomerResponseJson;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

  private static final String CUSTOMER_URI = "/customer";

  @MockBean
  private CustomerService customerServiceMock;

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;


  @Test
  public void shouldDelegateCustomerCreationToServiceLayer() throws Exception {
    CustomerRequest customerRequest = CustomerUtils.defaultCustomerRequest();
    Customer createdCustomer = defaultCustomer();
    String customerResponseJson = getCustomerResponseJson();
    when(customerServiceMock.createCustomer(any(Customer.class))).thenReturn(createdCustomer);

    mvc.perform(MockMvcRequestBuilders.post(CUSTOMER_URI)
            .content(mapper.writeValueAsString(customerRequest))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(customerResponseJson));

    verify(customerServiceMock, times(1)).createCustomer(any(Customer.class));
  }

}