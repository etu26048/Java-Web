package com.spring.henallux.dataAccess.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.repository.CategoryTraductionRepository;

@Service
public class CategoryTraductionDAO {

	@Autowired
	private CategoryTraductionRepository categoryTraductionRepository;
		
	public String getLabelTrad(Long id, String idLanguage){
		
		return categoryTraductionRepository.findCategoryTrad(id, idLanguage);
	}
}
