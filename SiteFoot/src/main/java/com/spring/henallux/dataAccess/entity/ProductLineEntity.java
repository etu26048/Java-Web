package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ligneproduit")
public class ProductLineEntity {

	@Id
	@Column(name="Idproduit")
	private Integer id_produit;
	
	@Column(name="Quantite")
	private Integer Quantite;
	
	@Column(name="Prixreel")
	private Double real_price;
	
	@JoinColumn(name="Refcommande",referencedColumnName="Reference")
	@ManyToOne
	private OrderEntity orderEntity;
	
	@JoinColumn(name="Refproduit",referencedColumnName="Reference")
	@ManyToOne
	private ArticleEntity articleEntity;

	public Integer getQuantite() {
		return Quantite;
	}

	public void setQuantite(Integer quantite) {
		Quantite = quantite;
	}

	public Double getReal_price() {
		return real_price;
	}

	public void setReal_price(Double real_price) {
		this.real_price = real_price;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public ArticleEntity getArticleEntity() {
		return articleEntity;
	}

	public void setArticleEntity(ArticleEntity articleEntity) {
		this.articleEntity = articleEntity;
	}
	
	
	
	
}
