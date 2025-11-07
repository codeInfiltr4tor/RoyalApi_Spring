package com.RSM.RoyalApi.repository;

import com.RSM.RoyalApi.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PurchaseRepository extends JpaRepository<Purchase, UUID> {

    @Query("SELECT DISTINCT p FROM Purchase p LEFT JOIN FETCH p.items")
    List<Purchase> findAllWithItems();

}
