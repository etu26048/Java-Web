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

@Controller
@RequestMapping(value="/register")
@SessionAttributes({RegistrationController.CURRENTUSER})
public class RegistrationController {

	protected static final String CURRENTUSER = "currentUser";
	
	@ModelAttribute(CURRENTUSER)
	public Customer customer(){
		return new Customer();
	}
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model
			,@ModelAttribute(value = CURRENTUSER)Customer customer
			,Locale locale){
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		//On passe le model à a la view et grâce à un databinding ,ici le ModelAtribute, on va pouvoir instancer customer
		//cf Ch.Controller P.21
		model.addAttribute("formCustomer",new Customer());
		return "integrated:register";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String getUserForm(Model model,
			@Valid @ModelAttribute(value="formCustomer") Customer customer
			,final BindingResult errors){
		if(errors.hasErrors()){
			customerDAO.save(customer);
			return "redirect:/index";
		}
		else{
			return "integrated:errors";
		}
	}
}
