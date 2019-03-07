package com.felisilv.bank.account.models;

import lombok.Data;

@Data
public class AccountRequest {
  private Long customerId;
  private AccountType type;
}
