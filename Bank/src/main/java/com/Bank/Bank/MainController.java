package com.Bank.Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 
@CrossOrigin(origins = "*")
@RequestMapping(path="/v1") 
public class MainController {
  @Autowired
  public static AccountsRepository accountsRepository; 
}