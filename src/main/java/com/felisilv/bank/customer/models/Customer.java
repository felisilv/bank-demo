package com.felisilv.bank.customer.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  @Size(min=2)
  private String firstName;

  @NotNull
  @Size(min=2)
  private String lastName;


  public Customer(CustomerDTO customerDTO) {
    firstName = customerDTO.getFirstName();
    lastName = customerDTO.getLastName();
  }

}
