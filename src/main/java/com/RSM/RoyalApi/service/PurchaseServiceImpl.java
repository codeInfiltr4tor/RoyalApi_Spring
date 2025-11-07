package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.entity.Purchase;
import com.RSM.RoyalApi.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService{

    private final PurchaseRepository purchaseRepository;

    /* Json structure
{
    "inoiceNo": 12345,
    "supplierName": "33ffffff Traders890",
    "address": "Gandhi Nagar, Delhi",
    "contact": "9876543210",
    "galaNo": "A-204",
    "gstNumber": "27ABCDE1234F1Z5",
    "purchaseDate": "2025-11-06",
    "totalGst": 175.0,
    "charges": 50.0,
    "transportCharges": 100.0,
    "labourCharges": 75.0,
    "totalCharges": 225.0,
    "totalAmount": 3725.0,
    "amountWithoutCharges": 3500.0,
    "items": [
        {
            "productName": "Sugar",
            "price": 40.0,
            "quantity": 50,
            "amount": 2000.0,
            "gstPercentage": 5.0,
            "gstAmount": 100.0
        },
        {
            "productName": "Salt",
            "price": 15.0,
            "quantity": 0.980,
            "amount": 1500.0,
            "gstPercentage": 5.0,
            "gstAmount": 75.0
        }
    ]
}
     */

    @Override
    @Transactional
    public Purchase addPurchase(Purchase purchase){
        return purchaseRepository.save(purchase);
    }

    @Override
    @Transactional
    public Purchase updatePurchase(UUID id, Purchase updatedpurchase){
        return purchaseRepository.findById(id).map(existing -> {
            existing.setSupplierName(updatedpurchase.getSupplierName());
            existing.setInoiceNo(updatedpurchase.getInoiceNo());
            existing.setAddress(updatedpurchase.getAddress());
            existing.setContact(updatedpurchase.getContact());
            existing.setGalaNo(updatedpurchase.getGalaNo());
            existing.setGstNumber(updatedpurchase.getGstNumber());
//            existing.setItems(updatedpurchase.getItems());
            existing.setTotalGst(updatedpurchase.getTotalGst());
            existing.setCharges(updatedpurchase.getCharges());
            existing.setTransportCharges(updatedpurchase.getTransportCharges());
            existing.setLabourCharges(updatedpurchase.getLabourCharges());
            existing.setTotalCharges(updatedpurchase.getTotalCharges());
            existing.setTotalAmount(updatedpurchase.getTotalAmount());
            existing.setAmountWithoutCharges(updatedpurchase.getAmountWithoutCharges());

            existing.getItems().clear();
            if(updatedpurchase.getItems() != null){
                updatedpurchase.getItems().forEach(item -> {
                    item.setPurchase(existing);
                    existing.getItems().add(item);
                });
            }

            return purchaseRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("No Purchase Record with ID : "+id));
    }

    @Override
    public void deletePurchase(UUID id){
        if(!purchaseRepository.existsById(id)){
            throw new RuntimeException("No Purchase Record with ID : "+id);
        }
        purchaseRepository.deleteById(id);
    }

    @Override
    public List<Purchase> getAllPurchases(){
//        return purchaseRepository.findAll();
        return purchaseRepository.findAllWithItems();
    }

    @Override
    public Optional<Purchase> getPurchaseByID(UUID id){
        return purchaseRepository.findById(id);
    }


}
