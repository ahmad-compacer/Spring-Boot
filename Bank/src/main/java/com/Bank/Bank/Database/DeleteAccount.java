package com.Bank.Bank.Database;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Bank.Bank.MainController;

public class DeleteAccount {
	@DeleteMapping(path="/delete/{id}")
	 public ResponseEntity<Void> delete(@PathVariable int id) {
		MainController.accountsRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	 }
}
