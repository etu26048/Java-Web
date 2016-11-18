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
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Promo getReferencePromo() {
		return referencePromo;
	}

	public void setReferencePromo(Promo referencePromo) {
		this.referencePromo = referencePromo;
	}

	public Category getReferenceCategory() {
		return referenceCategory;
	}

	public void setReferenceCategory(Category referenceCategory) {
		this.referenceCategory = referenceCategory;
	}

	@Column(name="ReferenceCategorie")
	private Category referenceCategory;
	

}
