package com.Bank.Bank.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.Bank.Accounts;
import com.Bank.Bank.AccountsRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/v1")
public class CreateNewAccount {
	@Autowired
	  private AccountsRepository accountsRepository;
	
	@PostMapping(
		value = "/add", 
		consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
  		produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  
    public ResponseEntity<Accounts> addNewAccount(@RequestBody Accounts accountDetails ) {
	  
	 Accounts n = new Accounts();
	 n.setName(accountDetails.getName());
	 n.setIban(accountDetails.getIban());
	 n.setBalance(accountDetails.getBalance());

	 accountsRepository.save(n);
	 return new ResponseEntity<Accounts>(n, HttpStatus.OK);	  
  	 }
}