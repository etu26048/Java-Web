package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.henallux.dataAccess.entity.OrderEntity;
import com.spring.henallux.dataAccess.repository.OrderRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Order;

public class OrderDAO {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	//Sert à quoi cette méthode ?
	public Order save(Order order){
		OrderEntity orderEntity = providerConverter.orderModelToOrderEntity(order);
		orderEntity = orderRepository.save(orderEntity);
		return providerConverter.orderEntityToOrderModel(orderEntity);		
	}
	
	//Implémente la méthode de base de l'interface du REPOSITORY
	//Permet de rechercher TOUTES les orders dans la database
	public ArrayList<Order> getAllOrders(){
		List<OrderEntity> ordersEntity = orderRepository.findAll();
		ArrayList<Order> orders = new ArrayList<Order>();
		for(OrderEntity entity : ordersEntity){
			//On va convertir une entity ,qu'on à récupérer dans la database
			//Et on va la transformer en model ,pour ne pas mélanger la persistence et le style de stockage
			//de données.
			Order order = providerConverter.orderEntityToOrderModel(entity);
			orders.add(order);
		}
		
		return orders;	
	}

}
