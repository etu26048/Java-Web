package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.ArticleTraductionEntity;

@Repository
public interface ArticleTraductionRepository extends JpaRepository<ArticleTraductionEntity, String>{

	String FIND_TRADUCTION_ARTICLE = "select label from ArticleTraductionEntity t "
							+" where t.articleEntity.reference = :refArticle and t.languageEntity.idLangue = :idLang";
	
	@Query(FIND_TRADUCTION_ARTICLE)
	public String findArticleTraduction(@Param("refArticle") String reference, @Param("idLang") String lang);
}
