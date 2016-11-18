package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.henallux.dataAccess.entity.OrderEntity;


public interface OrderRepository extends JpaRepository<OrderEntity, String> {

}
