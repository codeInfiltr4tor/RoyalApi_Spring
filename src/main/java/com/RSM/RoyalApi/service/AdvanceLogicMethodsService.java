package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface AdvanceLogicMethodsService {

    Double getCustomerOldBalance(String customerName);

//    @Autowired
//    private SalesRepository salesRepository;
//
//    @Autowired
//    private SalesPaymentRepository salesPaymentRepository;
//
//    @Override
//    public Double getCustomerOldBalance(String customerName) {
//        Double totalSales = salesRepository
//                .findByCustomerName(customerName)
//                .stream()
//                .mapToDouble(sale -> sale.getTotalAmount() != null ? sale.getTotalAmount() : 0.0)
//                .sum();
//
//        Double totalPayments = salesPaymentRepository
//                .findByCustomerName(customerName)
//                .stream()
//                .mapToDouble(payment -> payment.getPaidAmount() != null ? payment.getPaidAmount() : 0.0)
//                .sum();
//
//        return totalSales - totalPayments;
//    }


}
