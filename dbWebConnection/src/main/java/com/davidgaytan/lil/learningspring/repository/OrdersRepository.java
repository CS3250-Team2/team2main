package com.davidgaytan.lil.learningspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidgaytan.lil.learningspring.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {
	//  List<Orders> findByOrderProductId(String orderproductId );

}
