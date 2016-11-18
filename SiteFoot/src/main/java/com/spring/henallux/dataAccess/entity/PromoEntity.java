package com.spring.henallux.dataAccess.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Promo")
public class PromoEntity {

	@Id
	@Column(name="Reference")
	private Integer reference;
	
	@Column(name="Percent")
	private Double percent;
	
	@Column(name="DateDebut")
	private Date start_date;
	
	@Column(name="DateFin")
	private Date end_date;
	
}
