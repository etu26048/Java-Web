package com.spring.henallux.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Customer {
	
	private Long clientNumber;
	@NotEmpty
	@Size(min=2,max=50)
	@Pattern(regexp="^[A-Za-z]+$")
	private String lastName;
	@NotEmpty 	@Pattern(regexp="^[A-Za-z]+$")
	@Size(min=2,max=50)
	private String firstName;
	@Email
	@NotEmpty
	@Size(min=5,max=100)
	private String mail;
	@NotEmpty
	@Pattern(regexp="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")
	@Size(min=2,max=20)
	private String password;
	@NotEmpty
	@Size(min=2, max=20)
	private String confirmPassword;
	@Size(min=0,max=12)
	private String phone;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date birthdate;
	@NotEmpty
	@Size(min=2,max=4)
	private String civility;
	@NotEmpty @Pattern(regexp="^[A-Za-z]+$")
	@Size(min=5,max=50)
	private String country;
	@NotEmpty
	@Size(min=5,max=50)
	private String street;
	@NotEmpty
	@Size(min=1,max=5)
	private String number;
	//@Size(min=1,max=4)
	private String postal_box;
	@NotNull
	@Min(value=1000)
	@Max(value=9999)
	private Integer postalCode;
	@NotEmpty
	@Size(min=2,max=50)
	private String city;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Long getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(Long clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getCivility() {
		return civility;
	}
	public void setCivility(String civility) {
		this.civility = civility;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPostal_box() {
		return postal_box;
	}
	public void setPostal_box(String postal_box) {
		this.postal_box = postal_box;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
		
	
}
