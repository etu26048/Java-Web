package com.spring.henallux.dataAccess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.henallux.model.Customer;

@Entity
@Table(name="Commande")
public class OrderEntity {

	@Id
	@Column(name="Reference")
	private String reference;
	
	@Column(name="DateCommande")
	private Date order_date;
	
	@Column(name="MontantReduction")
	private Double reduction_amount;
	
	@Column(name="NumeroCli")
	private Customer customer;
}
