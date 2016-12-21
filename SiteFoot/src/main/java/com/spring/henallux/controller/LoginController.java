package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.dataAccess.dao.CustomerDAO;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Customer;

@Controller
@RequestMapping(value="/login")
@SessionAttributes({"currentUser"})
public class LoginController {
	
	private String password;
	private String login;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	//Comment faire pour envoyer juste le mdp et le login ? 
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model
			,Locale locale){
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		model.addAttribute("password",password);
		return "integrated:login";
	}
	
	@RequestMapping(value="/sign in",method=RequestMethod.POST)
	public String confirmLogin(Model model
			,@ModelAttribute(value="password")String password
			,@ModelAttribute(value="login")String login){
		
		Customer customer = customerDAO.findLogin(login);
		if(customer != null && customer.getPassword().equals(password))
		{
			//A réussi à se connecter avec succés, est redirigé vers la page d'accueil
			return "redirect:/index";
		}else return "integrated:erreur";
	}
}
