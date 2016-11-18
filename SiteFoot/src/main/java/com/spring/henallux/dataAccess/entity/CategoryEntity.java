package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Categorie")
public class CategoryEntity {

	@Id
	@Column(name="IdCategorie")
	private Integer category_id;
	
}
