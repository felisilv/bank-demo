package com.felisilv.bank.account;

import com.felisilv.bank.account.models.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Validated
class AccountService {

  private final AccountRepository accountRepository;

  Account createAccount(@Valid Account account) {
    return accountRepository.save(account);
  }

}
