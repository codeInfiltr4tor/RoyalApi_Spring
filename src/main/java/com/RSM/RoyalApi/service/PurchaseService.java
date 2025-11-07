package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.entity.Purchase;
import com.RSM.RoyalApi.repository.PurchaseRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PurchaseService {

    // private final PurchaseRepository purchaseRepository;

    public Purchase addPurchase(Purchase purchase);

    public Purchase updatePurchase(UUID id, Purchase updatedpurchase);

    public void deletePurchase(UUID id);

    public List<Purchase> getAllPurchases();

    public Optional<Purchase> getPurchaseByID(UUID id);

}
