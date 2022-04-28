package com.example.CS3250Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CS3250Project.model.Product;

@Repository
public interface ProductIdRepository extends JpaRepository <Product, Long> {

}
