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
@RequestMapping(value="/0")
public class ShoesController {

	//Category : 0->chaussures 1->v�tements 2->ballons
	@Autowired
	private ArticleDAO articleDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String product(Model model
			,Locale locale){
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);

		model.addAttribute("articles",articleDAO.getArticlesByCategory(categoryDAO.getSearchCategory((long) 0)));
		model.addAttribute("categories",categoryDAO.getAllCategories());
		
		return "integrated:shoes";
	}
}