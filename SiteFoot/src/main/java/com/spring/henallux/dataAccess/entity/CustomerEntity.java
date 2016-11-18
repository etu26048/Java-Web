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
	
}
