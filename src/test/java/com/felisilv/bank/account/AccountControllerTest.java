package com.felisilv.bank.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felisilv.bank.account.models.Account;
import com.felisilv.bank.account.models.AccountDTO;
import com.felisilv.bank.account.utils.AccountUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {

  private static final String ACCOUNT_URI = "/account";

  @MockBean
  private AccountService accountServiceMock;

  @Autowired
  private MockMvc mvc;

  @Autowired
  private ObjectMapper mapper;

  @Test
  public void shouldDelegateCurrentAccountCreationToServiceLayer() throws Exception {
    AccountDTO accountDTO = AccountUtils.getDefaultCurrentAccountDTO();
    Account createdAccount = AccountUtils.getDefaultCurrentAccount();
    when(accountServiceMock.createAccount(any(Account.class))).thenReturn(createdAccount);

    mvc.perform(MockMvcRequestBuilders.post(ACCOUNT_URI)
            .content(mapper.writeValueAsString(accountDTO))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(createdAccount.getId().toString()));

    verify(accountServiceMock, times(1)).createAccount(any(Account.class));
  }

  @Test
  public void shouldDelegateSavingsAccountCreationToServiceLayer() throws Exception {
    AccountDTO accountDTO = AccountUtils.getDefaultSavingsAccountDTO();
    Account createdAccount = AccountUtils.getDefaultSavingsAccount();
    when(accountServiceMock.createAccount(any(Account.class))).thenReturn(createdAccount);

    mvc.perform(MockMvcRequestBuilders.post(ACCOUNT_URI)
            .content(mapper.writeValueAsString(accountDTO))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(createdAccount.getId().toString()));

    verify(accountServiceMock, times(1)).createAccount(any(Account.class));
  }

}