package com.Bank.Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller 
@CrossOrigin(origins = "*")
@RequestMapping(path="/v1") 
public class MainController {
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

  
		 @GetMapping(path="/accounts")
		 public @ResponseBody Iterable<Accounts> getAllUsers() {
		 return accountsRepository.findAll();
		 }
		 
		 @DeleteMapping(path="/delete/{id}")
		 public ResponseEntity<Void> delete(@PathVariable int id) {
			 accountsRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		 }
}