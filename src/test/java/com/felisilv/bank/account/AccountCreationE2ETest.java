package com.felisilv.bank.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.felisilv.bank.account.models.Account;
import com.felisilv.bank.account.models.AccountRequest;
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

import static com.felisilv.bank.account.utils.AccountUtils.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountCreationE2ETest {
  @LocalServerPort
  private int port;

  @MockBean
  private AccountRepository accountRepository;

  @Before
  public void setUp() {
    RestAssured.port = port;
  }

  @Test
  public void shouldCreateCurrentAccountOnRestRequest() throws JsonProcessingException {
    AccountRequest accountRequest = getDefaultCurrentAccountRequest();
    Account account = getDefaultCurrentAccount();
    String accountResponseJson = getAccountResponseJson(CURRENT_ACCOUNT_ID);
    when(accountRepository.save(any(Account.class))).thenReturn(account);

    given()
            .contentType(ContentType.JSON)
            .body(accountRequest)
            .post("account")
            .then()
            .statusCode(HttpStatus.OK.value())
            .body(equalTo(accountResponseJson));

    verify(accountRepository, times(1)).save(any(Account.class));
  }

  @Test
  public void shouldCreateSavingsAccountOnRestRequest() throws JsonProcessingException {
    AccountRequest accountRequest = getDefaultCurrentAccountRequest();
    Account account = getDefaultSavingsAccount();
    String accountResponseJson = getAccountResponseJson(SAVINGS_ACCOUNT_ID);
    when(accountRepository.save(any(Account.class))).thenReturn(account);

    given()
            .contentType(ContentType.JSON)
            .body(accountRequest)
            .post("account")
            .then()
            .statusCode(HttpStatus.OK.value())
            .body(equalTo(accountResponseJson));

    verify(accountRepository, times(1)).save(any(Account.class));
  }
}
