package com.spring.henallux.dataAccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.henallux.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
