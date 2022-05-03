package com.example.CS3250Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.CS3250Project.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// Display list of Products
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listProducts", productService.getAllProducts()); 
		return "index";
	}
}
