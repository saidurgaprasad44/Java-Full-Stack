package com.example.notificationservice.service;

import com.example.contracts.event.InventoryReservedEvent;
import com.example.contracts.event.PaymentRefundedEvent;

public interface NotificationService {

    void sendOrderCompletedNotification(InventoryReservedEvent event);

    void sendOrderCancelledNotification(PaymentRefundedEvent event);
}