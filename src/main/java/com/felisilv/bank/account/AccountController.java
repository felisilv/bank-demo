package com.felisilv.bank.account;

import com.felisilv.bank.account.models.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class AccountController {

  private final AccountService accountService;

  @PostMapping("account")
  Long createAccount(@RequestBody AccountDTO accountDTO) {
    Long customerId = accountDTO.getCustomerId();
    Account account = null;

    if (accountDTO.getType() == AccountType.CURRENT) {
      CurrentAccount currentAccount = new CurrentAccount();
      currentAccount.setCustomerId(customerId);
      account = currentAccount;
    } else if (accountDTO.getType() == AccountType.SAVINGS) {
      SavingsAccount savingsAccount = new SavingsAccount();
      savingsAccount.setCustomerId(customerId);
      account = savingsAccount;
    }

    return accountService.createAccount(account).getId();
  }

}
