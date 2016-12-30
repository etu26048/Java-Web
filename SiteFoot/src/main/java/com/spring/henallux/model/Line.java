package com.spring.henallux.model;

public class Line {

	private Integer quantity;
	private Article article;
	
	
	public Line(){
		
	}
	
	public Line(Integer quantity,Article article){
		this.quantity = quantity;
		this.article = article;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
