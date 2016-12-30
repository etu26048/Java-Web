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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.ArticleDAO;
import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.dataAccess.dao.OrderDAO;
import com.spring.henallux.model.Cart;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Customer;
import com.spring.henallux.model.Line;
import com.spring.henallux.model.Order;
import com.spring.henallux.model.ProductLine;

@Controller
@RequestMapping(value="/cart")
@SessionAttributes({"currentUser", "basket"})
public class CartController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model
				,Locale locale
				,@ModelAttribute(value="basket")Cart cart){
		
		model.addAttribute("line", new Line());
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		return "integrated:cart";
	}
	
	@RequestMapping(params={"itemId"}
					,method=RequestMethod.GET)
	public String addToCart(Model model
			,Locale locale
			,@RequestParam(required = true)String itemId
			,@ModelAttribute(value="basket")Cart cart){
		
		model.addAttribute("line", new Line());
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		//Article article = articleDAO.findArticleById(itemId, locale.getLanguage());
		return "integrated:cart";
	}
	
	/*
	@RequestMapping(value="/create_order", method=RequestMethod.POST)
	public String createOrder(Model model
					,@ModelAttribute(value="currentUser") Customer customer
					,@Valid @ModelAttribute(value="basket") Cart cart
					,final BindingResult errors){
		if(!errors.hasErrors()){
			return "redirect:/index";
		}else return "integrated:errors";
		
	}*/
	
	@RequestMapping(value="/deleteLine")
	public String deleteFromCart(@Valid @ModelAttribute(value="line")Line product_line
			,@ModelAttribute(value="basket")Cart cart
			,final BindingResult errors){
		
		return "integrated:cart";
	}
	
	@RequestMapping(value="/minusQuantity")
	public String reduceQuantity(@Valid @ModelAttribute(value="line")Line product_line
			,@ModelAttribute(value="basket")Cart cart
			,final BindingResult errors){
		
		String product_ref = product_line.getArticle().getReference();
		Integer quantity = cart.getLine_map().get(product_ref).getQuantity();
		cart.getLine_map().get(product_ref).setQuantity(quantity--);
		return "integrated:cart";
	}
	
	@RequestMapping(value="/plusQuantity")
	public String addQuantity(@Valid @ModelAttribute(value="line")Line product_line
			,@ModelAttribute(value="basket")Cart cart
			,final BindingResult errors){
		
		String product_ref = product_line.getArticle().getReference();
		Integer quantity = cart.getLine_map().get(product_ref).getQuantity();
		cart.getLine_map().get(product_ref).setQuantity(quantity++);
		return "integrated:cart";
	}
}
