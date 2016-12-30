package com.spring.henallux.dataAccess.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.OrderEntity;
import com.spring.henallux.dataAccess.repository.OrderRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Order;

@Service
public class OrderDAO {

	@Autowired
	private ProviderConverter providerConverter;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public Order save(Order order){
		OrderEntity orderEntity = new OrderEntity();
		orderEntity = orderRepository.save(orderEntity);
		return providerConverter.orderEntityToOrderModel(orderEntity);
	}
}
