package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String>{

}
