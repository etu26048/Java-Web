package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.spring.henallux.dataAccess.dao.ProductLineDAO;
import com.spring.henallux.model.Article;
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
	
	@Autowired
	private ProductLineDAO productLineDAO;
	
	@ModelAttribute("amount")
	private Double amout(){
		return 0.00;
	}
	
	@ModelAttribute("amountWithReduction")
	private Double amountWithReduction(){
		return 0.00;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model
				,Locale locale
				,@ModelAttribute(value="basket")Cart cart){
		
		model.addAttribute("countItems",cart.getLine_map().size());
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
		
		model.addAttribute("countItems",cart.getLine_map().size());
		Article article = articleDAO.findArticleById(itemId, locale.getLanguage());
		model.addAttribute("line", new Line(cart.getLine_map().get(itemId).getQuantity(),article));
		ArrayList<Category> categories = categoryDAO.getLabelCategory(locale.getLanguage());
		model.addAttribute("labelsCategory",categories);
		return "integrated:cart";
	}
	
	@RequestMapping(value="/confirm_order", method=RequestMethod.POST)
	public String confirmOrder(Model model
					,@ModelAttribute(value="currentUser") Customer customer
					,@Valid @ModelAttribute(value="basket") Cart cart
					,final BindingResult errors){
		
		if(!errors.hasErrors()){
			if(customer.getClientNumber() == null || customer.getMail().isEmpty()){
				if(cart.getLine_map().isEmpty())
					return "redirect:/cart";
				return "redirect:/login";
			}else{
				return "integrated:confirmOrder";
			}
		}else
			return "integrated:errors";
	}
	
	@RequestMapping(value="/create_order", method=RequestMethod.POST)
	public String createOrder(Model model
					,@ModelAttribute(value="currentUser") Customer customer
					,@Valid @ModelAttribute(value="basket") Cart cart
					,@ModelAttribute(value="amountWithReduction") Double reduction
					,final BindingResult errors){
		
		if(!errors.hasErrors()){								
			//Création de la commande
			Order order = new Order();
			Date order_date = new Date();
			order.setCommandDate(order_date);
			order.setCustomer(customer);
			order.setReductionAmount(reduction);
			order = orderDAO.save(order);
			
			//Création de la ligne de commande
			ProductLine productLine = new ProductLine();
			for(Line line : cart.getLine_map().values()){
				
				productLine.setOrder(order);
				productLine.setProduct(line.getArticle());
				productLine.setQuantity(line.getQuantity());
				productLine.setRealPrice(line.getArticle().getUnitPrice());
				productLineDAO.save(productLine); 
			}
			
			//Vide la hashmap en session
			cart.getLine_map().clear();
			return "redirect:/index";
		}else{
			return "integrated:errors";
		}
		
	}
	
	@RequestMapping(value="/delete"
					,params={"lineKey"},
					method=RequestMethod.GET)
	public String deleteFromCart(@ModelAttribute(value="basket")Cart cart
			,final BindingResult errors
			,@RequestParam(required=true) String lineKey){
		
		cart.calculateAmount((cart.getLine_map().get(lineKey).getArticle().getUnitPrice() * cart.getLine_map().get(lineKey).getQuantity()));
		cart.countArticles(cart.getLine_map().get(lineKey).getQuantity());
		cart.getLine_map().remove(lineKey);
		
		return "redirect:/cart";
	}
	
}
