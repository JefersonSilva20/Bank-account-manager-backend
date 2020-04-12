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
@Entity(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAccount;
	@ManyToOne
	@JoinColumn(name = "id_person")
	private Person person;
	@Column(name = "balance")
	private double balance;
	@Column(name = "daily_withdrawal_limit")
	private double dailyWithdrawalLimit;
	@Column(name = "active_account")
	private boolean activeAccount;
	@Column(name = "account_type")
	private int accountType;
	@Column(name = "creation_date")
	private Date creationDate;
	
	public Account() {
		super();
	}
	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getDailyWithdrawalLimit() {
		return dailyWithdrawalLimit;
	}
	public void setDailyWithdrawalLimit(double dailyWithdrawalLimit) {
		this.dailyWithdrawalLimit = dailyWithdrawalLimit;
	}
	public boolean isActiveAccount() {
		return activeAccount;
	}
	public void setActiveAccount(boolean activeAccount) {
		this.activeAccount = activeAccount;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
