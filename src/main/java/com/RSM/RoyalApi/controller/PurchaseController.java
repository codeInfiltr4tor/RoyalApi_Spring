package com.RSM.RoyalApi.controller;

import com.RSM.RoyalApi.entity.Purchase;
import com.RSM.RoyalApi.entity.PurchaseItem;
import com.RSM.RoyalApi.service.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/Purchases")
@CrossOrigin(origins = "*") // optional: for Angular/Frontend use
public class PurchaseController {

    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

//    @PostMapping
//    public Purchase addPurchaseBill(@RequestBody Purchase purchase){
//        return purchaseService.addPurchase(purchase);
//    }
//
//    @GetMapping
//    public List<Purchase> getAllPurchaseBills(){
//        return purchaseService.getAllPurchases();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<Purchase> getPurchaseByID(@PathVariable Long id){
//        return purchaseService.getPurchaseByID(id);
//    }

    // ✅ Add a new purchase
    @PostMapping
    public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.addPurchase(purchase));
    }

    // ✅ Get all purchases
    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return ResponseEntity.ok(purchaseService.getAllPurchases());
    }

    // ✅ Get single purchase by ID
    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable UUID id) {
        return purchaseService.getPurchaseByID(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Update existing purchase
    @PutMapping("/{id}")
    public ResponseEntity<Purchase> updatePurchase(
            @PathVariable UUID id,
            @RequestBody Purchase purchase) {
        return ResponseEntity.ok(purchaseService.updatePurchase(id, purchase));
    }

    // ✅ Delete purchase
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable UUID id) {
        purchaseService.deletePurchase(id);
        return ResponseEntity.noContent().build();
    }

}
