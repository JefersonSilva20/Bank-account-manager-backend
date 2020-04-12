package com.conductor.challenger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.conductor.challenger.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query(value = "SELECT * FROM public.transactions WHERE id_account = ?1", nativeQuery = true)
	public List<Transaction> getAccountTransactions(int id);
	
	public List<Transaction> findByAccount(int id);

}
