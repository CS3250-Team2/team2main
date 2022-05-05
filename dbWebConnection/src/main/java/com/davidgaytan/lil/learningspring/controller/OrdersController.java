package com.davidgaytan.lil.learningspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.davidgaytan.lil.learningspring.model.Orders;
import com.davidgaytan.lil.learningspring.service.OrderService;

@Controller

public class OrdersController {
	@Autowired
	private OrderService orderService;
	

	
	/*
	display list of orders. Creating method handler for home page to display orders
	*/
	@GetMapping("orders")
	public String viewHomePage(Model model) {
		//List<Orders> listOrders = orderService.getAllOrders();
		model.addAttribute("listOrders", orderService.getAllOrders());
		return "index";
	}
}
  