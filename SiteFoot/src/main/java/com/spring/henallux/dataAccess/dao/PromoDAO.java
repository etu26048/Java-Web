package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.PromoEntity;
import com.spring.henallux.dataAccess.repository.PromoRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Promo;

@Service
public class PromoDAO {

	@Autowired
	private PromoRepository promoRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public ArrayList<Promo> getAllValidPromotionalArticles(){
		
		ArrayList<Promo> promos = new ArrayList<Promo>();
		ArrayList<PromoEntity> promoEntity = promoRepository.findAllValidPromoForArticles();
		
		for(PromoEntity value : promoEntity){
			
			Promo promo = providerConverter.promoEntityToModel(value);
			promos.add(promo);
		}
		return promos;		
	}
}
