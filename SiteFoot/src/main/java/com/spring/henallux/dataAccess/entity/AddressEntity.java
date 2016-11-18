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
}
