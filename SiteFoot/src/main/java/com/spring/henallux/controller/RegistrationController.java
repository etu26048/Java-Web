package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
@SessionAttributes({"currentUser"})
public class RegistrationController {

	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CryptingPassword cryptingPw;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model
			,Locale locale){
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		//On passe le model à a la view et grâce à un databinding ,ici le ModelAtribute, on va pouvoir instancer customer
		//cf Ch.Controller P.21
		//model.addAttribute("currentUser",customer);
		return "integrated:register";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String getUserForm(Model model,
			@Valid @ModelAttribute(value="currentUser") Customer customer
			,final BindingResult errors){
		
		if(!errors.hasErrors()){
			try{
				customer.setPassword(cryptingPw.cryptedPassword(customer.getPassword()));
				customer.setConfirmPassword(cryptingPw.cryptedPassword(customer.getConfirmPassword()));
				customerDAO.save(customer);
			}catch(Exception e){
				e.getStackTrace();
			}
			return "redirect:/index";
		}
		else{
			List<ObjectError> errors_list =  errors.getAllErrors();
			return "redirect:/register";
		}
	}
}
