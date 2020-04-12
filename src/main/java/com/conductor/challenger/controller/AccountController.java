package com.conductor.challenger.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.conductor.challenger.dto.TransactionDto;
import com.conductor.challenger.model.Account;
import com.conductor.challenger.model.Transaction;
import com.conductor.challenger.service.AccountService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(path = "accounts")
	public Page<Account> getAccounts(Pageable pageable) {
		return this.accountService.getAccountRepository().findAll(pageable);
	}

	@GetMapping(path = "accounts/{id}")
	public Optional<Account> getAccounts(@PathVariable int id) {
		return this.accountService.getAccountRepository().findById(id);
	}
	
	@PostMapping(value = "accounts")
	public ResponseEntity<Account> postAccount(@Valid @RequestBody Account account){
		return this.accountService.createAccount(account);
	}
	
	@GetMapping(value = "accounts/{id}/balance")
	public Double getAccountBalance(@PathVariable int id) {
		return  this.accountService.getAccountRepository().findById(id).get().getBalance();
	}
	
	@PutMapping(value = "api/accounts/{id}/deposit")
	public TransactionDto putAccountSetDeposit(@PathVariable int id, @Valid @RequestBody Double value) {
		return this.convertToDto(this.accountService.depositAccountTransaction(id, value));
	}
	
	@PutMapping(value = "accounts/{id}/withdrawal")
	public TransactionDto putAccountSetWithdrawal(@PathVariable int id, @Valid @RequestBody Double withdrawal) {
		return this.convertToDto(this.accountService.withdrawalAccountTransaction(id, withdrawal));
	}
	
	@PutMapping(value = "accounts/{id}/status")
	public Account putAccountSetActiveAccount(@PathVariable int id, @Valid @RequestBody Boolean status) {
		return this.accountService.setAccountStatus(id, status);
	}
	
	@GetMapping(value = "accounts/{id}/transactions")
	public List<TransactionDto> getAccountTransactions(@PathVariable int id){
		return this.accountService.getAccountTransactions(id).stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	private TransactionDto convertToDto(Transaction transaction) {
		TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);
	    return transactionDto;
	}
	
}
