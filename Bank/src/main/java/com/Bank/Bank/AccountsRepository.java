package com.Bank.Bank;


import org.springframework.data.repository.CrudRepository;

import com.Bank.Bank.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Integer> {

}