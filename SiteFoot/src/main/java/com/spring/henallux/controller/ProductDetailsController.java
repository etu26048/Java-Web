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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.ArticleDAO;
import com.spring.henallux.dataAccess.dao.CategoryDAO;
import com.spring.henallux.model.Article;
import com.spring.henallux.model.Cart;
import com.spring.henallux.model.Category;
import com.spring.henallux.model.Line;

@Controller
@RequestMapping(value="/product_detail")
@SessionAttributes({"currentUser", "basket"})
public class ProductDetailsController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ArticleDAO articleDAO;
	
	private Article articleDetail;
			
	
	@RequestMapping(value="/{articleId}", method=RequestMethod.GET)
	public String home(Model model
			, Locale locale
			, @PathVariable String articleId){
		
		model.addAttribute("line",new Line());
		articleDetail = articleDAO.findArticleById(articleId, locale.getLanguage());
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		model.addAttribute("article",articleDetail);
		return "integrated:product_details";
	}
	
	@RequestMapping(value="/addCart", method=RequestMethod.POST)
	public String addToCart(Model model
			,@ModelAttribute(value="basket")Cart cart
			,@ModelAttribute(value="line")Line line){
		
		line.setArticle(articleDetail);
		if(cart.getLine_map().containsKey(line.getArticle().getReference())){
			
			Integer quantity = cart.getLine_map().get(articleDetail.getReference()).getQuantity();
			quantity += line.getQuantity();
			cart.getLine_map().get(articleDetail.getReference()).setQuantity(quantity);
		}else{
			cart.getLine_map().put(line.getArticle().getReference(), line);
		}
		cart.calculateAmount();
		cart.countArticles();
		
		return "redirect:/cart?itemId="+articleDetail.getReference();
	}
	
	
}
