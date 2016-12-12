package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="traductioncategorie")
public class CategoryTraductionEntity {
	
	@Id
	@Column(name="IdTradCat")
	private Long id;
	
	@Column(name="Libelle")
	private String label;
	
	@JoinColumn(name="Refcategorie",referencedColumnName="Idcategorie")
	@ManyToOne
	private CategoryEntity categoryEntity;
	
	@JoinColumn(name="Reflangue",referencedColumnName="Idlangue")
	@ManyToOne
	private LanguageEntity languageEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public LanguageEntity getLanguageEntity() {
		return languageEntity;
	}

	public void setLanguageEntity(LanguageEntity languageEntity) {
		this.languageEntity = languageEntity;
	}
	
	

}
