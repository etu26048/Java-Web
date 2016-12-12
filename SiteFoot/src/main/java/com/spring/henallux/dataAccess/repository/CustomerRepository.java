package com.spring.henallux.dataAccess.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.CustomerEntity;
import com.spring.henallux.model.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	public Customer findByEmailLike(String email);
}
