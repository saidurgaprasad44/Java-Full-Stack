package com.example.notificationservice.service.impl;

import com.example.contracts.event.InventoryReservedEvent;
import com.example.contracts.event.PaymentRefundedEvent;
import com.example.notificationservice.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationServiceImpl
        implements NotificationService {

    @Override
    public void sendOrderCompletedNotification(
            InventoryReservedEvent event) {

        log.info(
                """
                EMAIL SENT

                Subject: Order Completed

                Order Id: {}
                Product Id: {}
                Quantity : {}
                """,
                event.orderId(),
                event.productId(),
                event.quantity());
    }

    @Override
    public void sendOrderCancelledNotification(
            PaymentRefundedEvent event) {

        log.info(
                """
                EMAIL SENT

                Subject: Order Cancelled

                Order Id: {}
                Reason   : {}
                """,
                event.orderId(),
                event.reason());
    }
}