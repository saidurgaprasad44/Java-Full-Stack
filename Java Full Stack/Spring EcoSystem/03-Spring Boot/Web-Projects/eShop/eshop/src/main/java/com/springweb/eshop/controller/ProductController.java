package com.springweb.eshop.controller;


import java.util.List;
import java.util.Optional;

import com.springweb.eshop.model.*;
import com.springweb.eshop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService prodService;


	@GetMapping("/products")
	public List<Product> getProducts() {
		return prodService.getProducts();
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable int id) {
		return prodService.getProductById(id);
	}
	
	@PostMapping("/products")
	public void addProduct(@RequestBody Product product) {
		prodService.addProduct(product);
	}
	
	@PutMapping("/products")
	public void updateProduct(@RequestBody Product product){
		prodService.updateProduct(product);
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		prodService.deleteProduct(id);
	}
}
