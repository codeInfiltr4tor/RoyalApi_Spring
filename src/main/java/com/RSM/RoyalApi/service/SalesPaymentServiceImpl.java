package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.entity.SalesPayment;
import com.RSM.RoyalApi.repository.SalesPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SalesPaymentServiceImpl implements SalesPaymentService{

    private final SalesPaymentRepository salesPaymentRepository;

    @Override
    public SalesPayment addSalesPaymentOfCustomer(SalesPayment salesPayment) {
        return salesPaymentRepository.save(salesPayment);
    }

    @Override
    public List<SalesPayment> getAllSalesPayment() {
        return salesPaymentRepository.findAll();
    }

    //    @Override
//    public List<SalesPayment> getAllPaymentOfCustomer(String customerName) {
//        return salesPaymentRepository.getAllPaymentOfCustomer(customerName).stream().toList();
//        return List.of();
//    }


//    @Override
//    public List<SalesPayment> getAllPaymentByBillNo(String billNo) {
//        return List.of();
//    }

    @Override
    public void deleteSalesPayment(UUID id) {

    }

    @Override
    public SalesPayment updateSalePaymentById(UUID id) {
        return null;
    }


}
