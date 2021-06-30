package com.Bank.Bank.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Bank.Bank.AccountsRepository;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/v1")
public class DeleteAccount {
	@Autowired
	  private AccountsRepository accountsRepository;
	
	@DeleteMapping(path="/delete/{id}")
	 public ResponseEntity<Void> delete(@PathVariable int id) {
		accountsRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	 }
}
