package com.spring.henallux.dataAccess.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.ProductLineEntity;
import com.spring.henallux.dataAccess.repository.ProductLineRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.ProductLine;

@Service
public class ProductLineDAO {

	
	@Autowired
	private ProductLineRepository productLineRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public ProductLine save(ProductLine productLine){
		ProductLineEntity productLineEntity = providerConverter.productLineModelToEntity(productLine);
		productLineEntity = productLineRepository.save(productLineEntity);
		return productLine;
	}
	
}
