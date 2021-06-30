package com.Bank.Bank.Database;

import org.apache.tomcat.jni.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Bank.Bank.Accounts;
import com.Bank.Bank.AccountsRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/v1")
public class PutMoney {
	
	@Autowired
	  private AccountsRepository accountsRepository;

	/*@PutMapping("/put")
	public ResponseEntity<Accounts> putMoney(@RequestBody Accounts user) {
		
		Integer id = user.getId();
		String newBalance = user.getBalance();
		
	    Accounts result = accountsRepository.updateById(id, newBalance);
	    
	    accountsRepository.save(result);

	    return new ResponseEntity<Accounts>(result, HttpStatus.OK);	
	    }*/
	
	  @PutMapping(value= "/{userId}", 
			    consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
			    public Accounts updateUser(@PathVariable String userId, @Validated @RequestBody AccountsRepository userDetails)    {
		  			Accounts storeUserDetails = user.get(userId);
		  			
		  			storeUserDetails.setBalance(userDetails.getBalance());
		  			user.put(userId, storeUserDetails);
		  			return storeUserDetails;
			    }
	}
