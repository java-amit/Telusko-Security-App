package com.telusko.SimpleWebApp.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.telusko.SimpleWebApp.model.Product;
import com.telusko.SimpleWebApp.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	
//	List<Product> products = new ArrayList<Product>(Arrays.asList(
//								new Product(101,"Iphone",50000),
//								new Product(102,"Canon Camera",70000),
//								new Product(103,"Shure Mic",10000)));
	
	public List<Product> getProduct(){
		return repo.findAll();		
	}

	public Product getProductById(int prodId) {
		return repo.findById(prodId).orElse(new Product());
	}
	
	public void addProduct(Product prod) {
		repo.save(prod);
	}

	public void updateProduct(Product prod) {
		repo.save(prod);
	}

	public void deleteProduct(int prodId) {
		repo.deleteById(prodId);
	}
}
