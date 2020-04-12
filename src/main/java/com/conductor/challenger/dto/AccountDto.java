package com.conductor.challenger.dto;


public class AccountDto {
	private int idAccount;
	
	private PersonDto person;
	
	public AccountDto() {
		super();
	}
	public PersonDto getPerson() {
		return person;
	}
	public void setPerson(PersonDto person) {
		this.person = person;
	}
	public int getIdAccount() {
		return idAccount;
	}
	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}
	

}
