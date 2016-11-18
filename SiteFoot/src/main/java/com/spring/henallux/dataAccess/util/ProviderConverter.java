package com.spring.henallux.dataAccess.util;

import org.springframework.stereotype.Component;

import com.spring.henallux.dataAccess.entity.OrderEntity;
import com.spring.henallux.model.Order;

//Sert à quoi le component ?
@Component
public class ProviderConverter {

	
	public OrderEntity orderModelToOrderEntity(Order order){
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setReference(order.getReference());
		orderEntity.setCustomer(order.getCustomer());
		orderEntity.setOrder_date(order.getCommandDate());
		orderEntity.setReduction_amount(order.getReductionAmount());
		return orderEntity;
	}
	
	public Order orderEntityToOrderModel(OrderEntity orderEntity){
		Order order = new Order();
		order.setCustomer(orderEntity.getCustomer());
		order.setCommandDate(orderEntity.getOrder_date());
		order.setReference(orderEntity.getReference());
		order.setReductionAmount(orderEntity.getReduction_amount());
		return order;
	}
}
