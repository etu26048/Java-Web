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
import com.spring.henallux.model.Article;
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
		model.addAttribute("countArticles",articleDAO.countArticle((long)0));
		model.addAttribute("articles",articleDAO.getArticlesByCategory(categoryDAO.getSearchCategory((long) 0),locale.getLanguage()));
		model.addAttribute("categories",categoryDAO.getAllCategories());
		model.addAttribute("category",categories.get(0));
		//return "integrated:shoes";
		return "integrated:product";
	}
	
	@RequestMapping(value="/details"
					, params={"articleId"}
					, method=RequestMethod.GET)
	public String goToDetails(@RequestParam(required=true) String articleId)
	{		
		return "redirect:/product_detail?articleId="+articleId;
	}
	
	@RequestMapping(value="/article"
			,params={"itemId"}
			,method=RequestMethod.GET)
	public String goToCart(@RequestParam(required = true) String itemId){
		
		return "redirect:/cart?itemId="+itemId;
	}
}
