package com.telusko.SimpleWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.SimpleWebApp.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	

}
