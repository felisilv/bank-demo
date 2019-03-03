package com.felisilv.bank.account.models;

import lombok.Data;

@Data
public class AccountDTO {
  private Long customerId;
  private AccountType type;
}
