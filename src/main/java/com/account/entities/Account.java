package com.account.entities;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@SequenceGenerator(name="accountsequence",initialValue = 123456,allocationSize = 1)
@Table(name="account")
public class Account {
	private  static final String IFSC="HG6700";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "account")
	private long accountNumber;
	private double balance;
	private boolean active;
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	private AccountType account;
	public long getAccountNumber() {
		return accountNumber;
	}
	//@JsonIgnore
	//@OneToOne(mappedBy="account", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Customer customer;
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountType getAccount() {
		return account;
	}
	public void setAccount(AccountType account) {
		this.account = account;
	}
	public static String getIfsc() {
		return IFSC;
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Account(long accountNumber, double balance, AccountType account) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.account = account;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", account=" + account + "]";
	}
	
	
	

}
