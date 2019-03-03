package com.felisilv.bank.account.utils;

import com.felisilv.bank.account.models.AccountDTO;
import com.felisilv.bank.account.models.AccountType;
import com.felisilv.bank.account.models.CurrentAccount;
import com.felisilv.bank.account.models.SavingsAccount;

public class AccountUtils {

  private AccountUtils() {
  }

  public static CurrentAccount getDefaultCurrentAccount() {
    CurrentAccount currentAccount = new CurrentAccount();
    currentAccount.setId(1L);
    currentAccount.setCustomerId(2L);

    return currentAccount;
  }

  public static SavingsAccount getDefaultSavingsAccount() {
    SavingsAccount savingsAccount = new SavingsAccount();
    savingsAccount.setId(3L);
    savingsAccount.setCustomerId(4L);

    return savingsAccount;
  }

  public static AccountDTO getDefaultCurrentAccountDTO() {
    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setCustomerId(5L);
    accountDTO.setType(AccountType.CURRENT);

    return accountDTO;
  }

  public static AccountDTO getDefaultSavingsAccountDTO() {
    AccountDTO accountDTO = new AccountDTO();
    accountDTO.setCustomerId(6L);
    accountDTO.setType(AccountType.SAVINGS);

    return accountDTO;
  }
}
