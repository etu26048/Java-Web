package com.spring.henallux.dataAccess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Numeroclient")
	private Long client_number;

	@Column(name="Nom")
	private String name;
	
	@Column(name="Prenom")
	private String first_name;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Motdepasse")
	private String password;
	
	@Column(name="Confirmpw")
	private String confirmPassword;
	
	@Column(name="Telephone")
	private String phone_number;
	
	@Column(name="Datenaissance",columnDefinition = "Date")
	private Date birthdate;
	
	@Column(name="Civilite")
	private String civility;
	
	@Column(name="Pays")
	private String country;
	
	@Column(name="Ville")
	private String city;
	
	@Column(name="Codepostal")
	private Integer postalCode;
	
	@Column(name="Rue")
	private String street;
	
	@Column(name="Numero")
	private String Number;
	
	@Column(name="Boite")
	private String box;

	public Long getClient_number() {
		return client_number;
	}

	public void setClient_number(Long client_number) {
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	

	
	
}
