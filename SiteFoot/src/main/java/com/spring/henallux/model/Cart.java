package com.spring.henallux.model;

import java.util.HashMap;

public class Cart {

	
	private HashMap<String, Line> line_map = new HashMap<String, Line>();
	
	public Cart(){
		
	}

	public HashMap<String, Line> getLine_map() {
		return line_map;
	}

	public void setLine_map(HashMap<String, Line> line_map) {
		this.line_map = line_map;
	}
	
}
