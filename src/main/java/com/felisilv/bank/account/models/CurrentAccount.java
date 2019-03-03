package com.felisilv.bank.account.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CurrentAccount extends Account {
  private BigDecimal maintenanceFee;

}
