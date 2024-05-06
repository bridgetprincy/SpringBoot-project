package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.ecommerce.global.GlobalData;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;


@Controller


public class HomeController {
	
	@Autowired
	CategoryService categoryServe;
	
	
	  @Autowired ProductService productServe;
	 

	 
	 
	
	  @GetMapping({"/","/home"}) 
	  
	  public String home(Model model) {
	  
	  model.addAttribute("cartCount", GlobalData.cart.size());
	
	  return "index"; 
	  
	  }
	 
	 
	  @GetMapping("/shop") 
	  public String shop(Model model) {
	  
	  model.addAttribute("categories", categoryServe.getAllCategory());
	  model.addAttribute("products", productServe.getAllProduct());
	  model.addAttribute("cartCount", GlobalData.cart.size());
	  
	  return "shop"; 
	  }
	 
	  
	
	  @GetMapping("/shop/category/{id}") 
	  
	  public String shopByCategory(Model model, @PathVariable int id) {
	  
	  model.addAttribute("categories", categoryServe.getAllCategory());
	  model.addAttribute("cartCount", GlobalData.cart.size());
	  model.addAttribute("products", productServe.getAllProductsByCategoryId(id));
	  
	  return "shop"; 
	  }
	 

	
	  @GetMapping("/shop/viewproduct/{id}") 
	  public String viewProduct(Model model, @PathVariable int id) {
	  
	  model.addAttribute("product", productServe.getProductById(id).get());
	  model.addAttribute("cartCount", GlobalData.cart.size());
	  
	  return "viewProduct"; 
	  }
	 
	
}
