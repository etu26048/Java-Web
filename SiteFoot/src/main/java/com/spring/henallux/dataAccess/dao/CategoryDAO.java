package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.dataAccess.repository.CategoryRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Category;

@Service
public class CategoryDAO {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	@Autowired
	private CategoryTraductionDAO categoryTraductionDAO;
	//Inutile ? 
	public Category save(Category category){
		//On transforme le model qu'on récupère en entity,
		CategoryEntity categoryEntity = providerConverter.categoryModelToEntity(category);
		//On enregistre l'entity dans la base de données cf cours avec la séparation de la persistance des données
		categoryEntity = categoryRepository.save(categoryEntity);
		return providerConverter.categoryEntityToModel(categoryEntity);		
	}
	
	public ArrayList<Category> getAllCategories(){
		List<CategoryEntity> categoriesEntity = categoryRepository.findAll();
		ArrayList<Category> categories = new ArrayList<Category>();
		for(CategoryEntity categoryEntity : categoriesEntity){
			Category category = providerConverter.categoryEntityToModel(categoryEntity);
			categories.add(category);
		}
		return categories;
	}
	
	public CategoryEntity getSearchCategory(Long id){
		return categoryRepository.findOne(id);
	}
	
	public ArrayList<Category> getLabelCategory(String idLanguage){
		ArrayList<Category> categories = getAllCategories();
		for(Category value : categories){
			value.setName(categoryTraductionDAO.getLabelTrad(value.getId(), idLanguage));
		}
		return categories;
	}
}
