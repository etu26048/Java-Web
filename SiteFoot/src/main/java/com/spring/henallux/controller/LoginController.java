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
import com.spring.henallux.model.LoginForm;
import com.spring.henallux.service.CryptingPassword;

@Controller
@RequestMapping(value="/login")
@SessionAttributes({"currentUser"})
public class LoginController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private CryptingPassword cryptingPw;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model
			,Locale locale
			,@ModelAttribute(value = "loginForm")LoginForm loginForm){
		
		model.addAttribute("loginForm", new LoginForm());
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		return "integrated:login";
	}
	
	@RequestMapping(value="/send",method=RequestMethod.POST)
	public String confirmLogin(Model model
			, @ModelAttribute(value="loginForm") LoginForm loginForm){
		
		Customer customer = customerDAO.findLogin(loginForm.getPseudo());
		if(customer != null){
			try{
				loginForm.setPassword(cryptingPw.cryptedPassword(loginForm.getPassword()));
				if(customer.getPassword().equals(loginForm.getPassword())){
					model.addAttribute("currentUser", customer);
					return "redirect:/index";
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return "integrated:errors";
	}
	
	@RequestMapping(value="/disconnect", method=RequestMethod.GET)
	public String disconnecting(Model model
					,@ModelAttribute(value="currentUser") Customer currentUser){
		
		model.addAttribute("currentUser", new Customer());
		return "redirect:/index";
	}
}
