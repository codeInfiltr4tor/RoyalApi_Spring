package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product updateproduct(Long Id, Product product);
    Product getProductById(Long Id);
    void deleteProduct(Long Id);


}
