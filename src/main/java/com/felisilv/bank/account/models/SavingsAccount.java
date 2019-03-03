package com.felisilv.bank.account.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SavingsAccount extends Account {
  private double interestRate;

}
