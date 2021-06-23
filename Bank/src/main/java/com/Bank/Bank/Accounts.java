package com.Bank.Bank;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity // This tells Hibernate to make a table out of this class
public class Accounts {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  @NotNull
  private String name;
  @NotNull
  private String Iban;
  @NotNull
  private String Balance;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


public String getIban() {
	return Iban;
}

public void setIban(String Iban) {
	this.Iban = Iban;
}

public String getBalance() {
	return Balance;
}

public void setBalance(String Balance) {
	this.Balance = Balance;
}
}