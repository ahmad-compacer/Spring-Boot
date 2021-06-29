package com.Bank.Bank.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.Bank.Accounts;
import com.Bank.Bank.AccountsRepository;


@RestController
public class GetAllAccounts {
	 @Autowired
	  private AccountsRepository accountsRepository;
	 
	 @GetMapping(path="/accounts")
	 public @ResponseBody Iterable<Accounts> getAllUsers() {
	 return accountsRepository.findAll();
	 }
}
