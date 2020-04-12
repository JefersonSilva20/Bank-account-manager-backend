package com.conductor.challenger.dto;

import java.util.Date;


public class TransactionDto {
	private int idTransaction;
	
	private AccountDto account;
	
	private double value;
	
	private Date dataTransaction;
	
	public TransactionDto() {
		super();
	}
	
	public TransactionDto(AccountDto account, double value, Date dataTransaction) {
		super();
		this.account = account;
		this.value = value;
		this.dataTransaction = dataTransaction;
	}

	public AccountDto getAccount() {
		return account;
	}
	public void setAccount(AccountDto account) {
		this.account = account;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Date getDataTransaction() {
		return dataTransaction;
	}
	public void setDataTransaction(Date dataTransaction) {
		this.dataTransaction = dataTransaction;
	}

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}
}
