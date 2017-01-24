package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.dataAccess.dao.CustomerDAO;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Customer;
import com.spring.henallux.service.CryptingPassword;

@Controller
@RequestMapping(value="/register")
@SessionAttributes({"currentUser", "basket"})
public class RegistrationController {

	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CryptingPassword cryptingPw;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	private ArrayList<Category> categories;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model
			,Locale locale){
		
		categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		return "integrated:register";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String getUserForm(Model model,
			@Valid @ModelAttribute(value="currentUser") Customer customer
			,final BindingResult errors
			,Locale locale){
		
		categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		
		if(!errors.hasErrors()){
			if(!customer.getConfirmPassword().equals(customer.getPassword())){
				errors.rejectValue("confirmPassword", "notmatch.password");
				return "integrated:register";
			}else{
				try{
					customer.setPassword(cryptingPw.cryptedPassword(customer.getPassword()));
					customer.setConfirmPassword(cryptingPw.cryptedPassword(customer.getConfirmPassword()));
					customer = customerDAO.save(customer);
				}catch(Exception e){
					e.getStackTrace();
				}
				return "redirect:/login";
			}
		}
		else{
			
			return "integrated:register";
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/create")
	public String registerBis(Model model,@Valid @ModelAttribute(value="currentUser")Customer currentUser,final BindingResult errors,Locale locale){
		return "redirect:/register";
	}
	
}
