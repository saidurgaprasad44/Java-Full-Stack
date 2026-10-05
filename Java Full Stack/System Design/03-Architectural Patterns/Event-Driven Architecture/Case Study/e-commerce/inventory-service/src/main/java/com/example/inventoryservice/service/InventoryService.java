package com.example.inventoryservice.service;

import com.example.contracts.event.PaymentSucceededEvent;

public interface InventoryService {

    void reserveInventory(PaymentSucceededEvent event);
}