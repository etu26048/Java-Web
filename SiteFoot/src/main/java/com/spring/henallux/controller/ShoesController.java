package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.henallux.dataAccess.dao.ArticleDAO;
import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.model.Category;

@Controller
@RequestMapping(value="/0")
public class ShoesController {

	//Category : 0->chaussures 1->vêtements 2->ballons
	@Autowired
	private ArticleDAO articleDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String product(Model model
			,Locale locale){
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		model.addAttribute("shoesCount",articleDAO.countShoes());
		model.addAttribute("articles",articleDAO.getArticlesByCategory(categoryDAO.getSearchCategory((long) 0),locale.getLanguage()));
		model.addAttribute("categories",categoryDAO.getAllCategories());
		return "integrated:shoes";
	}
	
	@RequestMapping(value="/details"
					, params={"articleId"}
					, method=RequestMethod.GET)
	public String goToDetails(@RequestParam(required=true) String articleId)
	{		
		return "redirect:/product_detail?articleId="+articleId;
	}
}
