package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.CustomerEntity;
import com.spring.henallux.dataAccess.repository.CustomerRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Customer;

@Service
public class CustomerDAO {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProviderConverter providerConverter;
	
	public Customer save(Customer customer){
		
		CustomerEntity customerEntity = providerConverter.customerModelToCustomerEntity(customer);
		customerEntity = customerRepository.save(customerEntity);
		return providerConverter.customerEntityToCustomerModel(customerEntity);
	}
	
	public ArrayList<Customer> getAllCustomer(){
		List<CustomerEntity> customersEntity = customerRepository.findAll();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		for(CustomerEntity value : customersEntity){
			Customer customer = providerConverter.customerEntityToCustomerModel(value);
			customers.add(customer);
		}
		return customers;
	}
	
	public Customer findLogin(String email){
		if(customerRepository.findByEmail(email) == null){
			return null;
		}
		return providerConverter.customerEntityToCustomerModel(customerRepository.findByEmail(email));
	}
}
