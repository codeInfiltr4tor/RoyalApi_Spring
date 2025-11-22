package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.repository.SalesPaymentRepository;
import com.RSM.RoyalApi.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AdvanceLogicMethodsImpl implements AdvanceLogicMethodsService{

    private final SalesRepository salesRepository;
    private final SalesPaymentRepository salesPaymentRepository;

    @Override
    public Double getCustomerOldBalance(String customerName) {

        Double totalSales = salesRepository.findByCustomerName(customerName).stream()
                .mapToDouble(sale -> sale.getTotalAmount() != null ? sale.getTotalAmount() : 0.0)
                .sum();
        Double totalPayments = salesPaymentRepository.findByCustomerName(customerName).stream()
                .mapToDouble(payment -> payment.getPaidAmount() != null ? payment.getPaidAmount() : 0.0)
                .sum();

        System.out.println("TotalSales : " + totalSales+ " , TotalPayment : "+totalPayments);

        return totalSales - totalPayments;
    }
}
