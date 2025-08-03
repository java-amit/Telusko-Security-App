package com.telusko.SimpleWebApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SimpleWebApp.Service.ProductService;
import com.telusko.SimpleWebApp.model.Product;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	@GetMapping("/products")
	public List<Product> getProduct() {
		return service.getProduct();
	}
	
	@GetMapping("/products/{prodId}")
	public Product getProductById(@PathVariable int prodId) {
		return service.getProductById(prodId);
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product prod) {
		System.out.println(prod);
		service.addProduct(prod);
	}
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody Product prod) {
		System.out.println("in here in update");
		service.updateProduct(prod);
	}
	
	@DeleteMapping("/products/{prodId}")
	public void deleteProduct(@PathVariable int prodId) {
		service.deleteProduct(prodId);
	}

}
