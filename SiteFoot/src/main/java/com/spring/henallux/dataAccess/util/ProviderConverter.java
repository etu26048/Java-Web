package com.spring.henallux.dataAccess.util;

import org.springframework.stereotype.Component;

import com.spring.henallux.dataAccess.entity.ArticleEntity;
import com.spring.henallux.dataAccess.entity.CategoryEntity;
import com.spring.henallux.dataAccess.entity.CustomerEntity;
import com.spring.henallux.dataAccess.entity.OrderEntity;
import com.spring.henallux.dataAccess.entity.ProductLineEntity;
import com.spring.henallux.model.Article;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Customer;
import com.spring.henallux.model.Order;
import com.spring.henallux.model.ProductLine;

@Component
public class ProviderConverter {

	
	public OrderEntity orderModelToOrderEntity(Order order){
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setReference(order.getReference());
		orderEntity.setCustomerEntity(customerModelToCustomerEntity(order.getCustomer()));
		orderEntity.setOrder_date(order.getCommandDate());
		orderEntity.setPromotion_amount(order.getReductionAmount());
		return orderEntity;
	}
	
	public Order orderEntityToOrderModel(OrderEntity orderEntity){
		Order order = new Order();
		order.setCustomer(customerEntityToCustomerModel(orderEntity.getCustomerEntity()));
		order.setCommandDate(orderEntity.getOrder_date());
		order.setReference(orderEntity.getReference());
		order.setReductionAmount(orderEntity.getPromotion_amount());
		return order;
	}
	
	public CustomerEntity customerModelToCustomerEntity(Customer customer){
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setBirthdate(customer.getBirthdate());
		customerEntity.setCivility(customer.getCivility());
		customerEntity.setEmail(customer.getMail());
		customerEntity.setFirst_name(customer.getFirstName());
		customerEntity.setName(customer.getLastName());
		customerEntity.setPhone_number(customer.getPhone());
		customerEntity.setPassword(customer.getPassword());
		customerEntity.setCountry(customer.getCountry());
		customerEntity.setCity(customer.getCity());
		customerEntity.setStreet(customer.getStreet());
		customerEntity.setNumber(customer.getNumber());
		customerEntity.setBox(customer.getPostal_box());
		customerEntity.setPostalCode(customer.getPostalCode());
		customerEntity.setConfirmPassword(customer.getConfirmPassword());
		return customerEntity;
	}
	
	public Customer customerEntityToCustomerModel(CustomerEntity customerEntity){
		Customer customer= new Customer();
		customer.setBirthdate(customerEntity.getBirthdate());
		customer.setCivility(customerEntity.getCivility());
		customer.setFirstName(customerEntity.getFirst_name());
		customer.setLastName(customerEntity.getName());
		customer.setMail(customerEntity.getEmail());
		customer.setPassword(customerEntity.getPassword());
		customer.setCountry(customerEntity.getCountry());
		customer.setCity(customerEntity.getCity());
		customer.setPostalCode(customerEntity.getPostalCode());
		customer.setStreet(customerEntity.getStreet());
		customer.setNumber(customerEntity.getNumber());
		customer.setPostal_box(customerEntity.getBox());
		customer.setConfirmPassword(customerEntity.getConfirmPassword());
		return customer;	
	}
	
	public Article articleEntityToModel(ArticleEntity articleEntity){
		Article article = new Article();
		article.setReference(articleEntity.getReference());
		article.setUnitPrice(articleEntity.getPrixUnitaire());
		article.setUrlImage(articleEntity.getUrlImage());
		return article;
	}
	
	public ArticleEntity articleModelToArticleEntity(Article article){
		ArticleEntity articleEntity = new ArticleEntity();
		articleEntity.setReference(article.getReference());
		articleEntity.setUrlImage(article.getUrlImage());
		articleEntity.setPrixUnitaire(article.getUnitPrice());
		return articleEntity;
	}
	
	public Category categoryEntityToModel(CategoryEntity categoryEntity){
		Category category = new Category();
		category.setId(categoryEntity.getId());
		return category;
	}
	
	public CategoryEntity categoryModelToEntity(Category category){
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setId(category.getId());
		return categoryEntity;
	}
	
	public ProductLine productLineEntityToModel(ProductLineEntity productLineEntity){
		
		ProductLine productLine = new ProductLine();
		productLine.setQuantity(productLineEntity.getQuantite());
		productLine.setOrder(orderEntityToOrderModel(productLineEntity.getOrderEntity()));
		productLine.setProduct(articleEntityToModel(productLineEntity.getArticleEntity()));
		productLine.setRealPrice(productLineEntity.getReal_price());
		return productLine;
	}
	
	public ProductLineEntity productLineModelToEntity(ProductLine productLine){
		
		ProductLineEntity productLineEntity = new ProductLineEntity();
		productLineEntity.setQuantite((productLine.getQuantity()));
		productLineEntity.setOrderEntity(orderModelToOrderEntity(productLine.getOrder()));
		productLineEntity.setArticleEntity(articleModelToArticleEntity(productLine.getProduct()));
		productLineEntity.setReal_price(productLine.getRealPrice());
		return productLineEntity;
	}
	 
	
	
}
