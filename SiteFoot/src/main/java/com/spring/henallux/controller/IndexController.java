package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.henallux.dataAccess.dao.ArticleDAO;
import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.model.Category;

@Controller
@RequestMapping(value="/index")
public class IndexController {
		
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ArticleDAO articleDAO;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale){
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("articles",articleDAO.getAllArticles());
		model.addAttribute("labelsCategory",categories);
		return "integrated:index";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String goToRegisterPage(Model model){
		
		return "redirect:/register";
	}
	
	
}
