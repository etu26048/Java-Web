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
										+"a.category = :idCategory";
	
	String COUNT_SHOES = "select count(*) from ArticleEntity a where "
										+"a.category = 0";
	
	String COUNT_CLOTHES = "select count(*) from ArticleEntity a where "
										+"a.category = 1";
	
	String COUNT_BALLS = "select count(*) from ArticleEntity a where "
										+"a.category = 2";
	
	public List<ArticleEntity> findByCategory(CategoryEntity id);
	
	@Query(COUNT_ARTICLE_BY_CATEGORY)
	public long countArticleByCategory(@Param("idCategory") Integer id);

	@Query(COUNT_SHOES)
	public Integer countShoes();
	
	@Query(COUNT_CLOTHES)
	public Integer countClothes();
	
	@Query(COUNT_BALLS)
	public Integer countBalls();
	

}
