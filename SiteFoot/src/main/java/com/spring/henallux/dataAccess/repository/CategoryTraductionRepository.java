package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.CategoryTraductionEntity;

@Repository
public interface CategoryTraductionRepository extends JpaRepository<CategoryTraductionEntity, Long>{

	String FIND_TRADUCTION = "select label from CategoryTraductionEntity c "
						+"where c.categoryEntity.id = :refCat and c.languageEntity.idLangue = :refLangue";
	
	@Query(FIND_TRADUCTION)
	public String findCategoryTrad(@Param("refCat") Long refCat, @Param("refLangue") String refLangue);
}
