package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Langue")
public class LanguageEntity {

	@Id
	@Column(name="IdLangue")
	private String langue_id;

	public String getLangue_id() {
		return langue_id;
	}

	public void setLangue_id(String langue_id) {
		this.langue_id = langue_id;
	}
	
}
