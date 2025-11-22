package com.RSM.RoyalApi.repository;

import com.RSM.RoyalApi.entity.SalesPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SalesPaymentRepository extends JpaRepository<SalesPayment, UUID> {

//    public List<SalesPayment> getAllPaymentOfCustomer(String customerName);
//    public List<SalesPayment> getAllPaymentByBillNo(String billNo);

    List<SalesPayment> findByCustomerName(String customerName);

}
