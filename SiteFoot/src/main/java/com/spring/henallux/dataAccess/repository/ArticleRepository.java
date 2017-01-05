package com.spring.henallux.dataAccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.ArticleEntity;
import com.spring.henallux.dataAccess.entity.CategoryEntity;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, String>{
	
	String COUNT_ARTICLE_BY_CATEGORY = "select count(*) from ArticleEntity a where "
										+"a.category.id = :idCategory";
	
	
	public List<ArticleEntity> findByCategory(CategoryEntity id);
	
	@Query(COUNT_ARTICLE_BY_CATEGORY)
	public Integer countArticleByCategory(@Param("idCategory") Long id);	

	
}
