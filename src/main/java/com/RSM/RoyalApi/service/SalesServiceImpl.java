package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.entity.Sale;
import com.RSM.RoyalApi.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService{

    private final SalesRepository salesRepository;

    /* Dummy Json structure
{
  "billNo": "S-2025-001",
  "saleDate": "2025-11-04",
  "customerName": "Rajesh raju",
  "phoneNo": "9876543210",
  "address": "Mumbai, India",
  "totalAmount": 2450.0,
  "salesItems": [
    {
      "productName": "Sugar",
      "quantity": 2.5,
      "rate": 40.0,
      "amount": 100.0
    },
    {
      "productName": "Tea Powder",
      "quantity": 1.0,
      "rate": 150.0,
      "amount": 150.0
    },
    {
      "productName": "Rice",
      "quantity": 10.0,
      "rate": 220.0,
      "amount": 2200.0
    }
  ]
}
     */

    @Override
    @Transactional
    public Sale addSalesBill(Sale sale) {
        return salesRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public Sale getSalesBillByID(UUID id) {
        return salesRepository.findById(id).orElseThrow(() -> new RuntimeException("Sales Not found by ID : "+id));
    }

    @Override
    @Transactional
    public Sale updateSalesBill(UUID id, Sale sale) {
        return salesRepository.findById(id).map(existing -> {
            existing.setCustomerName(sale.getCustomerName());
//            existing.setBillNo(sale.getBillNo());
            existing.setAddress(sale.getAddress());
            existing.setSaleDate(sale.getSaleDate());
            existing.setPhoneNo(sale.getPhoneNo());
            existing.setTotalAmount(sale.getTotalAmount());
            existing.setTransportCharges(sale.getTransportCharges());
            existing.setOldBalance(sale.getOldBalance());

            // clearing the existing arrays
            existing.getSalesItems().clear();
            if(sale.getSalesItems() != null){
                sale.getSalesItems().forEach(item -> {
                    item.setSale(existing);
                    existing.getSalesItems().add(item);
                });

            }

            return salesRepository.save(existing);

        }).orElseThrow(() -> new RuntimeException("Sales Not found by ID : "+id));
    }

    @Override
    public void deleteSalesBill(UUID id) {
        if(!salesRepository.existsById(id)){
            throw new RuntimeException("Sales Not found by ID : "+id);
        }
        salesRepository.deleteById(id);
    }
}
