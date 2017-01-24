package com.spring.henallux.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ProductLine {

	private Integer id_produit;
	public Integer getId_produit() {
		return id_produit;
	}
	public void setId_produit(Integer id_produit) {
		this.id_produit = id_produit;
	}
	@Min(value=0)
	@Max(value=1000)
	private Integer Quantity;
	private Double realPrice;
	private Order order;
	private Article product;
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public Double getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(Double realPrice) {
		this.realPrice = realPrice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Article getProduct() {
		return product;
	}
	public void setProduct(Article product) {
		this.product = product;
	}
	
	
}
