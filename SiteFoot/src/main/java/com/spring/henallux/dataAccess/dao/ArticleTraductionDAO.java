package com.spring.henallux.dataAccess.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.repository.ArticleTraductionRepository;

@Service
public class ArticleTraductionDAO {
	
	@Autowired
	private ArticleTraductionRepository articleTraductionRepository;
	
	
	public String getTradLabelByArticle(String id, String codeLanguage){
		return articleTraductionRepository.findArticleTraduction(id, codeLanguage);
	}
}
