package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value="/category")
@SessionAttributes({"currentUser", "basket"})
public class ProductController {
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	private ArrayList<Category> categories;
	
	private String word;
	
	@RequestMapping(value="/0", method=RequestMethod.GET)
	public String getShoesPage(Model model
			, Locale locale){
		
		categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		model.addAttribute("countArticles",articleDAO.countArticle((long) 0));
		model.addAttribute("articles",articleDAO.getArticlesByCategory(categoryDAO.getSearchCategory((long) 0),locale.getLanguage()));
		return "integrated:product";
	}
	
	@RequestMapping(value="/1", method=RequestMethod.GET)
	public String getClothesPage(Model model
			, Locale locale){
		
		categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		model.addAttribute("countArticles",articleDAO.countArticle((long) 1));
		model.addAttribute("articles",articleDAO.getArticlesByCategory(categoryDAO.getSearchCategory((long) 1),locale.getLanguage()));
		return "integrated:product";
	}
	
	@RequestMapping(value="/2", method=RequestMethod.GET)
	public String getBallsPage(Model model
			, Locale locale){
		
		categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		model.addAttribute("countArticles",articleDAO.countArticle((long) 2));
		model.addAttribute("articles",articleDAO.getArticlesByCategory(categoryDAO.getSearchCategory((long) 2),locale.getLanguage()));
		return "integrated:product";
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public String getContactPage(Model model){
		
		model.addAttribute("labelsCategory",categories);
		return "integrated:contact";
	}
	
	/*@RequestMapping(value="/details"
			, params={"articleId"}
			, method=RequestMethod.GET)
	public String goToDetails(@RequestParam(required=true) String articleId)
	{		
		return "redirect:/product_detail/detail?articleId="+articleId;
	}*/
		
	//Ajouter au panier
	@RequestMapping(value="/article"
			,params={"itemId"}
			,method=RequestMethod.GET)
	public String productSummary(@RequestParam(required = true) String itemId
			,@ModelAttribute(value="basket")Cart cart
			,Locale locale){
		
		if(cart.getLine_map().containsKey(itemId)){
			//Clé déjà présente, qte ++
			Integer quantity = cart.getLine_map().get(itemId).getQuantity();
			cart.getLine_map().get(itemId).setQuantity(++quantity);
		}else
		{
			Article article = articleDAO.findArticleById(itemId, locale.getLanguage());
			Line line = new Line(1,article);
			cart.getLine_map().put(itemId, line);
		}
		cart.calculateAmount();
		cart.countArticles();
		return "redirect:/cart?itemId="+itemId;
	}
	
	@RequestMapping(value="/search",params={"searchWord"},method=RequestMethod.POST)
	public String getSearchPage(Model model, @RequestParam(required=false) String searchWord, Locale locale){
		
		word = searchWord;
		if(!searchWord.isEmpty()){
			categories = categoryDAO.getLabelCategory(locale.getLanguage());
			model.addAttribute("labelsCategory",categories);
			model.addAttribute("countArticles",articleDAO.searchArticles(searchWord, locale.getLanguage()).size());
			model.addAttribute("articles", articleDAO.searchArticles(searchWord, locale.getLanguage()));
			return "integrated:search_response";
		}
		else{return "redirect:/index";}
	}
	

}
