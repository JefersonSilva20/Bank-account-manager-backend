package com.conductor.challenger.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.conductor.challenger.dto.TransactionDto;
import com.conductor.challenger.model.Transaction;
import com.conductor.challenger.service.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "api/transactions")
	public List<TransactionDto> getTransactions(){
		return this.transactionService.getTransactionRepository().findAll()
				.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@GetMapping(value = "api/transactions/{id}")
	public TransactionDto getTransactions(@PathVariable int id){
		return this.convertToDto(this.transactionService.getTransactionRepository().getOne(id));
	}
	
	private TransactionDto convertToDto(Transaction transaction) {
		TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);
	    return transactionDto;
	}
}
