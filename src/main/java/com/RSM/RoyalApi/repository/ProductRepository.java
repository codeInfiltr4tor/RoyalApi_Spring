package com.RSM.RoyalApi.repository;

import com.RSM.RoyalApi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
    // We’ll add custom queries later if needed
}
