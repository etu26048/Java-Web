package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.ArticleDAO;
import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.model.Article;
import com.spring.henallux.model.Cart;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Line;

@Controller
@RequestMapping(value="/1")
@SessionAttributes({"currentUser", "basket"})
public class ClothesController {
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model,
			Locale locale){
		
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		model.addAttribute("countArticles",articleDAO.countArticle((long)1));
		model.addAttribute("articles",articleDAO.getArticlesByCategory(categoryDAO.getSearchCategory((long)1),locale.getLanguage()));
		model.addAttribute("categories",categoryDAO.getAllCategories());
		model.addAttribute("category",categories.get(1));
		
		return "integrated:product";
	}
	
	@RequestMapping(value="/details"
			, params={"articleId"}
			, method=RequestMethod.GET)
	public String goToDetails(@RequestParam(required=true) String articleId)
	{		
		return "redirect:/product_detail?articleId="+articleId;
	}
	
	//Ajouter au panier
	@RequestMapping(value="/article"
			,params={"itemId"}
			,method=RequestMethod.GET)
	public String goToCart(@RequestParam(required = true) String itemId
			,@ModelAttribute(value="basket")Cart cart
			,Locale locale){
		
		if(cart.getLine_map().containsKey(itemId)){
			//Clé déjà présente, qte ++
			Integer quantity = cart.getLine_map().get(itemId).getQuantity();
			cart.getLine_map().get(itemId).setQuantity(quantity++);
		}else
		{
			Article article = articleDAO.findArticleById(itemId, locale.getLanguage());
			Line line = new Line(1,article);
			cart.getLine_map().put(itemId, line);
		}
		
		return "redirect:/cart?itemId="+itemId;
	}

}
