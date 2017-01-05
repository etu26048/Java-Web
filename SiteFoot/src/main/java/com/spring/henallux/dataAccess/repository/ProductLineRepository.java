package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.ProductLineEntity;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLineEntity, Integer> {

}
