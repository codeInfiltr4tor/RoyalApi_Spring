package com.RSM.RoyalApi.repository;

import com.RSM.RoyalApi.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SalesRepository extends JpaRepository<Sale, UUID> {

    List<Sale> findByCustomerName(String customerName);

}
