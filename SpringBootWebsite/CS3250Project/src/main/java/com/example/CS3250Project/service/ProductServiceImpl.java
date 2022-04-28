package com.example.CS3250Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.CS3250Project.model.Product;
import com.example.CS3250Project.repository.ProductIdRepository;

public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductIdRepository productIdRepository;
	
	//returns list of products to the controller
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productIdRepository.findAll();
	}

}
