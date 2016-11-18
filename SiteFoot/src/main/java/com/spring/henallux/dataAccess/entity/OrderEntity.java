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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Double getReduction_amount() {
		return reduction_amount;
	}

	public void setReduction_amount(Double reduction_amount) {
		this.reduction_amount = reduction_amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
