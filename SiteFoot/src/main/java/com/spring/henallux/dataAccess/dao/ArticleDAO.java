package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.ArticleEntity;
import com.spring.henallux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.dataAccess.repository.ArticleRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Article;

@Service
public class ArticleDAO {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public Article save(Article article){
		ArticleEntity articleEntity = providerConverter.articleModelToArticleEntity(article);
		articleEntity = articleRepository.save(articleEntity);
		return providerConverter.articleEntityToModel(articleEntity);
	}
	
	public ArrayList<Article> getAllArticles(){
		List<ArticleEntity> articlesEntity = articleRepository.findAll();
		ArrayList<Article> articles = new ArrayList<Article>();
		for(ArticleEntity value : articlesEntity){
			Article article = providerConverter.articleEntityToModel(value);
			articles.add(article);
		}
		return articles;
	}
	
	public Long countAllArticles(){
		return articleRepository.count();
	}
	
	public ArrayList<Article> getArticlesByCategory(CategoryEntity id){
		List<ArticleEntity> articlesEntity = articleRepository.findByCategory(id);
		ArrayList<Article> articles = new ArrayList<Article>();
		for(ArticleEntity value : articlesEntity){
			Article article = providerConverter.articleEntityToModel(value);
			articles.add(article);
		}
		return articles;
	}
}
