package com.example.analyticsservice.consumer;

import com.example.analyticsservice.service.AnalyticsService;
import com.example.contracts.constants.KafkaTopics;
import com.example.contracts.event.PaymentRefundedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * ==========================================
 * Handles Payment Refunded Events
 * ==========================================
 *
 * Responsibilities:
 * - Consume PaymentRefundedEvent
 * - Update Analytics Metrics
 *
 * Patterns Implemented:
 * - Event-Driven Analytics
 * - Eventual Consistency
 *
 * This consumer listens for payment refunds
 * triggered during Saga compensation and
 * updates cancelled order metrics.
 *
 * Flow:
 *
 * Payment Service
 *      ↓
 * payment-refunded (Kafka Topic)
 *      ↓
 * Analytics Service
 *      ↓
 * Increment CANCELLED_ORDERS
 */
@Component
@RequiredArgsConstructor
public class PaymentRefundedConsumer {

    private final AnalyticsService analyticsService;

    /**
     * Consumes PaymentRefundedEvent and increments
     * the cancelled orders metric.
     */
    @KafkaListener(
            topics = KafkaTopics.PAYMENT_REFUNDED,
            groupId = "analytics-service-group",
            containerFactory =
                    "paymentRefundedKafkaListenerContainerFactory"
    )
    public void consume(
            PaymentRefundedEvent event) {

        /*
         * Update analytics metrics when
         * an order is cancelled and the
         * payment has been refunded.
         */
        analyticsService.incrementCancelledOrders();
    }
}