package com.account.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.account.Exception.AccountNotFoundException;
import com.account.Exception.CustomerNotFoundException;
import com.account.Exception.NoSufficientAmountException;
import com.account.entities.Account;
import com.account.entities.Customer;
import com.account.repository.AccountRepository;
import com.account.service.AccountService;


@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public void deposit(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(AccountNotFoundException::new);
		account.setBalance(account.getBalance() + amount);
		
	}

	@Override
	public void withdraw(Long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).orElseThrow(AccountNotFoundException::new);
		if(account.getBalance()-amount<500) {
			throw new NoSufficientAmountException();
		}
		accountRepository.save(account);
	}
	

	/*@Override
	public void transfer(Long fromAccNumber, Long toAccNumber, double amount) {

		Account account = accountRepository.findById(fromAccNumber).orElseThrow(AccountNotFoundException::new);

		if (account.getBalance() - amount < 5000)
			throw new NoSufficientAmountException();
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);*/
	
	@Override
	public List<Account> getAllAccounts() {
		return (List<Account>) accountRepository.findAll();
	}
	
	@Override
	public Customer getCustomerById(Long id) {
		return accountRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
	}

	@Override
	public Account getAccountById(Long accountNumber) {
		return accountRepository.findByaccountNumber(accountNumber).orElseThrow(AccountNotFoundException);
	}

}
