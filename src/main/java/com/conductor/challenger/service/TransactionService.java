package com.conductor.challenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conductor.challenger.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}
}
