package com.felisilv.bank.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.felisilv.bank.customer.models.Customer;
import com.felisilv.bank.customer.models.CustomerRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static com.felisilv.bank.customer.utils.CustomerUtils.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerCreationE2ETest {
  @LocalServerPort
  private int port;

  @MockBean
  private CustomerRepository customerRepository;

  @Before
  public void setUp() {
    RestAssured.port = port;
  }

  @Test
  public void shouldCreateOwnerOnRestRequest() throws JsonProcessingException {
    CustomerRequest customerRequest = defaultCustomerRequest();
    Customer customer = defaultCustomer();
    String customerResponseJson = getCustomerResponseJson();
    when(customerRepository.save(any(Customer.class))).thenReturn(customer);

    given()
            .contentType(ContentType.JSON)
            .body(customerRequest)
            .when()
            .post("customer")
            .then()
            .statusCode(HttpStatus.OK.value())
            .body(equalTo(customerResponseJson));

    verify(customerRepository, times(1)).save(any(Customer.class));
  }

}
