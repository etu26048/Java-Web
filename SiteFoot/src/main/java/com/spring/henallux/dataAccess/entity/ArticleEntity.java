package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.spring.henallux.model.Category;
import com.spring.henallux.model.Promo;

@Entity
@Table(name="Produit")
public class ArticleEntity {
	
	@Id
	@Column(name="Reference")
	private String reference;
	
	@Column(name="UrlImage")
	private String urlImage;
	
	@Column(name="PrixUnitaire")
	private Double unitPrice;
	
	@Column(name="ReferencePromo")
	private Promo referencePromo;
	
	@Column(name="ReferenceCategorie")
	private Category referenceCategory;
	

}
