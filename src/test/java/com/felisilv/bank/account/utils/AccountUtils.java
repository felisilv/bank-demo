package com.felisilv.bank.account.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.felisilv.bank.account.models.*;

public class AccountUtils {

  public static final long CURRENT_ACCOUNT_ID = 1L;
  public static final long SAVINGS_ACCOUNT_ID = 3L;

  private static final ObjectMapper MAPPER = new ObjectMapper();

  private AccountUtils() {
  }

  public static CurrentAccount getDefaultCurrentAccount() {
    CurrentAccount currentAccount = new CurrentAccount();
    currentAccount.setId(CURRENT_ACCOUNT_ID);
    currentAccount.setCustomerId(2L);

    return currentAccount;
  }

  public static SavingsAccount getDefaultSavingsAccount() {
    SavingsAccount savingsAccount = new SavingsAccount();
    savingsAccount.setId(SAVINGS_ACCOUNT_ID);
    savingsAccount.setCustomerId(4L);

    return savingsAccount;
  }

  public static AccountRequest getDefaultCurrentAccountRequest() {
    AccountRequest accountRequest = new AccountRequest();
    accountRequest.setCustomerId(5L);
    accountRequest.setType(AccountType.CURRENT);

    return accountRequest;
  }

  public static AccountRequest getDefaultSavingsAccountRequest() {
    AccountRequest accountRequest = new AccountRequest();
    accountRequest.setCustomerId(6L);
    accountRequest.setType(AccountType.SAVINGS);

    return accountRequest;
  }

  public static String getAccountResponseJson(long accountId) throws JsonProcessingException {
    AccountResponse accountResponse = new AccountResponse();
    accountResponse.setAccountId(accountId);

    return MAPPER.writeValueAsString(accountResponse);
  }
}
