package com.springweb.eshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springweb.eshop.controller.HomeController;
import com.springweb.eshop.model.Product;
import com.springweb.eshop.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
	ProductRepo repo;

    ProductService(HomeController homeController) {
    }
	
	public List<Product> getProducts(){
		
		return 	(List<Product>) repo.findAll();
	}

	public Optional<Product> getProductById(int id) {
		
		return repo.findById(id);
	}

	public void addProduct(Product product) {
		
		repo.save(product);
	}

	public void updateProduct(Product product) {
		
		if(!repo.findById(product.getId()).equals(Optional.empty()))
			
			repo.save(product);
	}

	public void deleteProduct(int id) {
		
		repo.deleteById(id);
	}
}
