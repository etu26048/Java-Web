package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.ArticleEntity;
import com.spring.henallux.dataAccess.repository.ArticleTraductionRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Article;

@Service
public class ArticleTraductionDAO {
	
	@Autowired
	private ArticleTraductionRepository articleTraductionRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public String getTradLabelByArticle(String id, String codeLanguage){
		return articleTraductionRepository.findArticleTraduction(id, codeLanguage);
	}
	
	/*public ArrayList<Article> getAllTradedArticle(String codeLanguage){
		
		ArrayList<Article> articles = new ArrayList<Article>();
		ArrayList<String> labels =  articleTraductionRepository.findAllTradedArticle(codeLanguage);
		for(ArticleEntity value : articlesEntity){
			Article article =  providerConverter.articleEntityToModel(value);
			articles.add(article);
		}
		return articles;
	}*/
}
