package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Adresse")
public class AddressEntity {

	@Id
	@Column(name="IDAdresse")
	private Integer id_address;
	
	@Column(name="Pays")
	private String country;
	
	@Column(name="Ville")
	private String city;
	
	@Column(name="CodePostal")
	private Integer postal_code;
	
	@Column(name="Rue")
	private String street;
	
	@Column(name="Numero")
	private String number;
	
	@Column(name="BoitePostal")
	private String box;

	public Integer getId_address() {
		return id_address;
	}

	public void setId_address(Integer id_address) {
		this.id_address = id_address;
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

	public Integer getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(Integer postal_code) {
		this.postal_code = postal_code;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBox() {
		return box;
	}

	public void setBox(String box) {
		this.box = box;
	}
	
	
}
