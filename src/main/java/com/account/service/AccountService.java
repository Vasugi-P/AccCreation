package com.account.service;

import java.util.List;

import com.account.entities.Account;
import com.account.entities.Customer;

public interface AccountService {
	void deposit(Long accountNumber,double amount);
	void withdraw(Long accountNumber,double amount);
	//void transfer(Long fromAccountNumber,Long toAccountNumber double amount);
	public List<Account> getAllAccounts();
	Customer getCustomerById(Long accountNumber);
	Account getAccountById(Long accountNumber);

 
}
