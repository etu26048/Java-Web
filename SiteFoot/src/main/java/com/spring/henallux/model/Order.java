package com.spring.henallux.model;

import java.util.Date;

public class Order {
	
	private Integer reference;
	private Date commandDate;
	private double reductionAmount;
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getReference() {
		return reference;
	}
	public void setReference(Integer reference) {
		this.reference = reference;
	}
	public Date getCommandDate() {
		return commandDate;
	}
	public void setCommandDate(Date commandDate) {
		this.commandDate = commandDate;
	}
	public double getReductionAmount() {
		return reductionAmount;
	}
	public void setReductionAmount(double reductionAmount) {
		this.reductionAmount = reductionAmount;
	}
	

}
