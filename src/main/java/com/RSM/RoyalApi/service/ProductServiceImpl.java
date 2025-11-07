package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.entity.Product;
import com.RSM.RoyalApi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateproduct(Long Id, Product product) {

        Product existing = getProductById(Id);
        existing.setPName(product.getPName());
        existing.setDescription(product.getDescription());
        existing.setQty(product.getQty());
        existing.setCategory(product.getCategory());
        existing.setSellingPrice(product.getSellingPrice());
        productRepository.save(existing);

        return null;
    }

    @Override
    public Product getProductById(Long Id) {
        return productRepository.findById(Id).orElseThrow(() -> new RuntimeException("No Product found with id: " + Id));
    }

    @Override
    public void deleteProduct(Long Id) {
        productRepository.deleteById(Id);
    }
}
