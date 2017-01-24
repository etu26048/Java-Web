package com.spring.henallux.dataAccess.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.PromoEntity;

@Repository
public interface PromoRepository extends JpaRepository<PromoEntity, Integer> {

	String VALID_PROMO= "select p from PromoEntity p "
			+"where p.end_date >= curdate() and p.start_date <= curdate()";
	
	@Query(VALID_PROMO)
	public ArrayList<PromoEntity> findAllValidPromoForArticles();
}
