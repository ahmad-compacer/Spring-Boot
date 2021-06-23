package com.Bank.Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.fasterxml.jackson.annotation.JsonFilter;

@Controller 
@RequestMapping(path="/accounts") 
public class MainController {
  @Autowired
  private AccountsRepository accountsRepository;

  // post Parameter
 /* @PostMapping(path="/add") 
  public @ResponseBody String addNewKonto (@RequestParam String name
      , @RequestParam String Iban, @RequestParam Long balance) {*/
  
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

  
  @GetMapping(path="/all")
  public @ResponseBody Iterable<Accounts> getAllUsers() {

    return accountsRepository.findAll();
  }
 /* @DeleteMapping(path="/delete")
  public ResponseEntity<?> delete(@RequestParam(value = "id") String name) {
	  
	return new ResponseEntity<>(HttpStatus.OK);
	  
  }*/
}