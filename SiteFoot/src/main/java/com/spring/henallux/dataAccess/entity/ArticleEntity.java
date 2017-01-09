package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="produit")
public class ArticleEntity {

	@Id
	@Column(name="Reference")
	private String reference;
	
	@Column(name="Urlimage")
	private String urlImage;
	
	@Column(name="Prixunitaire")
	private Double prixUnitaire;

	@JoinColumn(name="Referencecategorie",referencedColumnName="Idcategorie")
	@ManyToOne
	private CategoryEntity category;
	
	@JoinColumn(name="Referencepromo", referencedColumnName="Reference")
	@ManyToOne
	private PromoEntity promo;
	
	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public PromoEntity getPromo() {
		return promo;
	}

	public void setPromo(PromoEntity promo) {
		this.promo = promo;
	}

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

	public Double getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
}
