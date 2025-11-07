package com.RSM.RoyalApi.service;

import com.RSM.RoyalApi.entity.Sale;
import java.util.List;
import java.util.UUID;

public interface SalesService {

    public Sale addSalesBill(Sale sale);
    public List<Sale> getAllSales();
    public Sale getSalesBillByID(UUID id);
    public Sale updateSalesBill(UUID id, Sale sale);
    public void deleteSalesBill(UUID id);

}
