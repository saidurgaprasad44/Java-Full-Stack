package com.springweb.eshop.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springweb.eshop.model.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {

}
