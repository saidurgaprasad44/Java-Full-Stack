package com.example.paymentservice.service;

import com.example.contracts.event.InventoryFailedEvent;
import com.example.contracts.event.OrderCreatedEvent;

public interface PaymentService {
    void processPayment(OrderCreatedEvent event);
    void refundPayment(InventoryFailedEvent event);
}