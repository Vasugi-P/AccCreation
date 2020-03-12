package com.account.controller;


import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entities.Account;
import com.account.entities.Customer;
import com.account.formbean.AccountForm;
import com.account.service.AccountService;

@RestController
@RequestMapping(path = "/acc")
public class AccountController {
	
	private AccountService as;
	
	@GetMapping(path = "account", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Account> getAllAccount() {
		return as.getAllAccounts();
	}
	@PutMapping(path="account/{accountNumber}") 
	public ResponseEntity<Account>updateAcc(@RequestBody AccountForm accForm,
			  @PathVariable(name="accountNumber") Long accountNumber ){ 
		  Customer cust=as.getCustomerById(accountNumber);
		  cust.setName(accForm.getName());
		  cust.setEmail(accForm.getEmail());
		  cust.setAddress(accForm.getAddress());
		  cust.setCity(accForm.getCity());
		  cust.setCountry(accForm.getCountry());
		  Account acc=as.getAccountById(accountNumber);
		  acc.setBalance(accForm.getBalance());
		  acc.setCustomer(cust);		  
	  cust.setAccount(acc); 
	  return new ResponseEntity<Account>(as.updateAccount(acc),HttpStatus.OK);
	  }
}
