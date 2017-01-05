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
	
	@Autowired
	private ArticleTraductionDAO articleTraductionDAO;
	
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
	
	public ArrayList<Article> getArticlesByCategory(CategoryEntity id, String codeLanguage){
		List<ArticleEntity> articlesEntity = articleRepository.findByCategory(id);
		ArrayList<Article> articles = new ArrayList<Article>();
		for(ArticleEntity value : articlesEntity){
			Article article = providerConverter.articleEntityToModel(value);
			article.setName(articleTraductionDAO.getTradLabelByArticle(value.getReference(), codeLanguage));
			articles.add(article);
		}
		return articles;
	}
	
	public Integer countArticle(Long id){
		return articleRepository.countArticleByCategory(id);
	}
	
	public Article findArticleById(String id, String codeLanguage){
		Article article = providerConverter.articleEntityToModel(articleRepository.findOne(id));
		article.setName(articleTraductionDAO.getTradLabelByArticle(article.getReference(), codeLanguage));
		return article;
	}
	
	/*public ArrayList<Article> getAllArticlesTraduction(String codeLanguage){
		ArrayList<Article> articles = getAllArticles();
		for(Article value : articles){
			value.setName(articleTraductionDAO.getTradLabelByArticle(value.getReference(), codeLanguage));
		}
		return articles;
	}*/
	
	
}
