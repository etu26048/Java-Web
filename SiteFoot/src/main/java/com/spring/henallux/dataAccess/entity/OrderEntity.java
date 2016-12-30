package com.spring.henallux.dataAccess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class OrderEntity {

	@Id
	@Column(name="Reference")
	private String reference;
	
	@Column(name="Datecommande")
	private Date order_date;
	
	@Column(name="Montantreduction")
	private Double promotion_amount;
	
	@JoinColumn(name="Numerocli",referencedColumnName="Numeroclient")
	@ManyToOne
	private CustomerEntity customerEntity;

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

	public Double getPromotion_amount() {
		return promotion_amount;
	}

	public void setPromotion_amount(Double promotion_amount) {
		this.promotion_amount = promotion_amount;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	
	
}
