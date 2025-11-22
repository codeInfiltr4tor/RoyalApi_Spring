package com.RSM.RoyalApi.controller;

import com.RSM.RoyalApi.entity.Sale;
import com.RSM.RoyalApi.repository.SalesPaymentRepository;
import com.RSM.RoyalApi.service.AdvanceLogicMethodsService;
import com.RSM.RoyalApi.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sales")
@CrossOrigin(origins = "*") // optional: for Angular/Frontend use
public class SalesController {

    private final SalesService salesService;
    private final AdvanceLogicMethodsService advanceLogicMethodsService;

    @PostMapping
    public Sale addSalesBill(@RequestBody Sale sale){
        return salesService.addSalesBill(sale);
    }

    @GetMapping
    public List<Sale> getAllSalesBills(){
        return salesService.getAllSales();
    }

    @GetMapping("/{id}")
    public Sale getSaleByID(@PathVariable UUID id){
        return salesService.getSalesBillByID(id);
    }

    @PutMapping("/{id}")
    public Sale updateSaleBill(@PathVariable UUID id, @RequestBody Sale sale){
        return salesService.updateSalesBill(id, sale);
    }

    @DeleteMapping("/{id}")
    public void deleteSaleBill(@PathVariable UUID id){
        salesService.deleteSalesBill(id);
    }

    @GetMapping("/balance/{custName}")
    public Double getBalanceOfCust(@PathVariable String custName){
        return advanceLogicMethodsService.getCustomerOldBalance(custName);
    }


}
