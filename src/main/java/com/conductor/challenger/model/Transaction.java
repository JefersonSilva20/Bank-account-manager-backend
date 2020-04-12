package com.conductor.challenger.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "transactions")
public class Transaction{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTransaction;
	@ManyToOne
	@JoinColumn(name = "id_account")
	private Account account;
	@Column(name = "value")
	private double value;
	@Column(name = "data_transaction")
	private Date dataTransaction;
	
	public Transaction() {
		super();
	}
	
	public Transaction(Account account, double value, Date dataTransaction) {
		super();
		this.account = account;
		this.value = value;
		this.dataTransaction = dataTransaction;
	}

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
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
