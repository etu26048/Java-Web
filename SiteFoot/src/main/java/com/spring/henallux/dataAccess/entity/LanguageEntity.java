package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="langue")
public class LanguageEntity {

	@Id
	@Column(name="Idlangue")
	private String idLangue;
}
