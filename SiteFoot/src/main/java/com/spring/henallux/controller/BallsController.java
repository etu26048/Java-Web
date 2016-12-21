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
@RequestMapping(value="/2")
public class BallsController {

	@Autowired
	private ArticleDAO articleDAO;
	
	@Autowired 
	private CategoryDAO categoryDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model,
			Locale locale){
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		model.addAttribute("ballsCount",articleDAO.countBalls());
		model.addAttribute("articles",articleDAO.getArticlesByCategory(categoryDAO.getSearchCategory((long)2),locale.getLanguage()));
		model.addAttribute("categories",categoryDAO.getAllCategories());
		
		model.addAttribute("countArticles",articleDAO.countAllArticles());
		return "integrated:Balls";
	}
}
