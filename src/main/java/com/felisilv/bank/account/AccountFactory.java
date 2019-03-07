package com.felisilv.bank.account;

import com.felisilv.bank.account.models.Account;
import com.felisilv.bank.account.models.AccountType;
import com.felisilv.bank.account.models.CurrentAccount;
import com.felisilv.bank.account.models.SavingsAccount;

class AccountFactory {

  private AccountFactory() {
  }

  static Account getAccount(AccountType type, Long customerId) {
    Account account = null;

    if (type == AccountType.CURRENT) {
      CurrentAccount currentAccount = new CurrentAccount();
      currentAccount.setCustomerId(customerId);
      account = currentAccount;
    } else if (type == AccountType.SAVINGS) {
      SavingsAccount savingsAccount = new SavingsAccount();
      savingsAccount.setCustomerId(customerId);
      account = savingsAccount;
    }

    return account;
  }

}
