package com.spring.henallux.dataAccess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="promo")
public class PromoEntity {

	@Id
	@Column(name="Reference")
	private Integer reference;
	
	@Column(name="Pourcentage")
	private Double pourcent;
	
	@Column(name="Datedebut")
	private Date start_date;
	
	@Column(name="Datefin")
	private Date end_date;

	public Integer getReference() {
		return reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

	public Double getPourcent() {
		return pourcent;
	}

	public void setPourcent(Double pourcent) {
		this.pourcent = pourcent;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
		
}
