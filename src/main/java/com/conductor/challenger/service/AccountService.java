package com.conductor.challenger.service;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.conductor.challenger.model.Account;
import com.conductor.challenger.model.Transaction;
import com.conductor.challenger.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class AccountService {
		
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired 
	private TransactionService transactionService;
	
	public Transaction depositAccountTransaction(int id, double value) {
		Account accountRetrieve =  this.accountRepository.findById(id).get();
		accountRetrieve.setBalance(accountRetrieve.getBalance() + value);
		this.accountRepository.save(accountRetrieve);
		return this.saveTransaction(accountRetrieve,value,Calendar.getInstance().getTime());
	}
	
	public Transaction withdrawalAccountTransaction(int id, double value) {
		Account accountRetrieve =  this.accountRepository.findById(id).get();
		accountRetrieve.setBalance(accountRetrieve.getBalance() - value);
		this.accountRepository.save(accountRetrieve);
		return this.saveTransaction(accountRetrieve,value,Calendar.getInstance().getTime());
	}
	
	private Transaction saveTransaction(Account account, double value, Date date) {
		return this.transactionService.getTransactionRepository().save(new Transaction(account,value,date));
	}
	
	public ResponseEntity<Account> createAccount(Account account) {
		Account accountSave = this.accountRepository.save(account);
		URI localization = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(accountSave.getIdAccount())
				.toUri();
		return ResponseEntity.created(localization).build();
		
	}
	
	public Account setAccountStatus(int id, boolean status){
		Account accountRetrieve =  this.accountRepository.findById(id).get();
		if(accountRetrieve != null){
			accountRetrieve.setActiveAccount(status);
		}
		return this.accountRepository.save(accountRetrieve);

	}

	public AccountRepository getAccountRepository() {
		return accountRepository;
	}

	public List<Transaction> getAccountTransactions(int id) {
		return this.transactionService.getTransactionRepository().getAccountTransactions(id);
	}
}
