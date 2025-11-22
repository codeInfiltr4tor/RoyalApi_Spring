package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.entity.SalesPayment;

import java.util.List;
import java.util.UUID;

public interface SalesPaymentService {

    public SalesPayment addSalesPaymentOfCustomer(SalesPayment salesPayment);
//    public List<SalesPayment> getAllPaymentOfCustomer(String customerName);
//    public List<SalesPayment> getAllPaymentByBillNo(String billNo);
    public List<SalesPayment> getAllSalesPayment();
    public void deleteSalesPayment(UUID id);
    public SalesPayment updateSalePaymentById(UUID id);

}
