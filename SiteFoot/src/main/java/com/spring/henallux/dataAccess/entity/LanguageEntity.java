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
	
}
