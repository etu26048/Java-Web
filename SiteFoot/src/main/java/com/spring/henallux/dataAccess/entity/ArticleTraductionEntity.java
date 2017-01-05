package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="traductionproduit")
public class ArticleTraductionEntity {

	@Id
	@Column(name="IdTradProd")
	private String id;
	
	@Column(name="Libelle")
	private String label;
	
	@JoinColumn(name="Refproduit",referencedColumnName="Reference")
	@ManyToOne
	private ArticleEntity articleEntity;
	
	@JoinColumn(name="Reflangue", referencedColumnName="Idlangue")
	@ManyToOne
	private LanguageEntity languageEntity;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ArticleEntity getArticleEntity() {
		return articleEntity;
	}

	public void setArticleEntity(ArticleEntity articleEntity) {
		this.articleEntity = articleEntity;
	}

	public LanguageEntity getLanguageEntity() {
		return languageEntity;
	}

	public void setLanguageEntity(LanguageEntity languageEntity) {
		this.languageEntity = languageEntity;
	}
	
	
}
