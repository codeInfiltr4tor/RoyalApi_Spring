package com.RSM.RoyalApi.controller;

import com.RSM.RoyalApi.entity.SalesPayment;
import com.RSM.RoyalApi.service.SalesPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salesPayment")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // optional: for Angular/Frontend use
public class SalesPaymentController {

    private final SalesPaymentService salesPaymentService;

    @PostMapping
    public SalesPayment addPaymentForBill(@RequestBody SalesPayment salesPayment){
        return salesPaymentService.addSalesPaymentOfCustomer(salesPayment);
    }

    @GetMapping
    public List<SalesPayment> getAllSalesPayment(){
        return salesPaymentService.getAllSalesPayment();
    }

}
