package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.henallux.model.Language;

public interface LanguageRepository extends JpaRepository<Language, String> {

}
