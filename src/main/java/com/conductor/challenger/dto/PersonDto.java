package com.conductor.challenger.dto;


public class PersonDto {
	private int idPerson;
	
	private String name;
	
	public PersonDto() {
		super();
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int id_person) {
		this.idPerson = id_person;
	}
	
}
