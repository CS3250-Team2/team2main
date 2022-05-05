package com.davidgaytan.lil.learningspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidgaytan.lil.learningspring.model.Orders;
import com.davidgaytan.lil.learningspring.repository.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Override
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
		
	}
	


}
