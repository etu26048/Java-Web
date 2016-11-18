package com.spring.henallux.dataAccess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.henallux.model.Address;

@Entity
@Table(name="Customer")
public class CustomerEntity {

	@Id
	@Column(name="NumeroClient")
	private long client_number;

	@Column(name="Nom")
	private String name;
	
	@Column(name="Prenom")
	private String first_name;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="MotDePasse")
	private String password;
	
	@Column(name="Telephone")
	private String phone_number;
	
	@Column(name="DateNaissance")
	private Date birthdate;
	
	@Column(name="Civilite")
	private String civility;
	
	@Column(name="Localite")
	private Address locality;

	public long getClient_number() {
		return client_number;
	}

	public void setClient_number(long client_number) {
		this.client_number = client_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
	}

	public Address getLocality() {
		return locality;
	}

	public void setLocality(Address locality) {
		this.locality = locality;
	}
	
	
}
