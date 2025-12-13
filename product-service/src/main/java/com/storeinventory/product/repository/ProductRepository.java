package com.storeinventory.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.storeinventory.product.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
