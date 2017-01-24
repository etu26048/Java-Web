package com.spring.henallux.model;

import java.util.HashMap;

public class Cart {

	
	private HashMap<String, Line> line_map = new HashMap<String, Line>();
	private Double amount;
	private Integer countArticle;
	
	public Cart(){
		
	}

	public HashMap<String, Line> getLine_map() {
		return line_map;
	}

	public void setLine_map(HashMap<String, Line> line_map) {
		this.line_map = line_map;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getCountArticle() {
		return countArticle;
	}

	public void setCountArticle(Integer countArticle) {
		this.countArticle = countArticle;
	}
	
	public void calculateAmount(){
		
		Double temp = 0.00;
		for(Line line : this.getLine_map().values()){
			
			temp+=(line.getArticle().getUnitPrice() * line.getQuantity());
		}
		setAmount(temp);
	}
	
	public void countArticles(){
		
		Integer temp = 0;
		for(Line line : this.getLine_map().values()){
			
			temp += line.getQuantity();
		}
		setCountArticle(temp);
	}
	
	public void calculateAmount(Double a){
		setAmount(amount -= a);
		
	}
	
	public void countArticles(Integer i){
		setCountArticle(countArticle -= i);
	}
	
}
