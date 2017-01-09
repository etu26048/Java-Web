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

import com.spring.henallux.dataAccess.dao.ArticleDAO;
import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.model.Cart;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Customer;

@Controller
@RequestMapping(value="/index")
@SessionAttributes({IndexController.CURRENTUSER, IndexController.BASKET})
public class IndexController {
		
	protected static final String BASKET = "basket";
	protected static final String CURRENTUSER = "currentUser";
	
	@ModelAttribute(CURRENTUSER)
	public Customer customer(){
		return new Customer();
	}
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@ModelAttribute("basket")
	public Cart basket(){
		return new Cart();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model
			, Locale locale
			,@ModelAttribute(value=CURRENTUSER)Customer customer
			,@ModelAttribute(value="basket")Cart cart){
		
		cart.calculateAmount();
		cart.countArticles();
		customer.getClass();
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("articles",articleDAO.getAllPromoArticles());
		model.addAttribute("labelsCategory",categories);
		return "integrated:index";
	}	
	
}
