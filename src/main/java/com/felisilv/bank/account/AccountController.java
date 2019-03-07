package com.felisilv.bank.account;

import com.felisilv.bank.account.models.Account;
import com.felisilv.bank.account.models.AccountRequest;
import com.felisilv.bank.account.models.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class AccountController {

  private final AccountService accountService;

  @PostMapping("account")
  AccountResponse createAccount(@RequestBody AccountRequest accountRequest) {
    Account account = AccountFactory.getAccount(accountRequest.getType(), accountRequest.getCustomerId());
    Account createdAccount = accountService.createAccount(account);

    AccountResponse accountResponse = new AccountResponse();
    accountResponse.setAccountId(createdAccount.getId());

    return accountResponse;
  }

}
