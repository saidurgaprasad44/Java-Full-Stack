package com.example.analyticsservice.consumer;

import com.example.analyticsservice.service.AnalyticsService;
import com.example.contracts.constants.KafkaTopics;
import com.example.contracts.event.InventoryReservedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * ==========================================
 * Handles Inventory Reserved Events
 * ==========================================
 *
 * Responsibilities:
 * - Consume InventoryReservedEvent
 * - Update Analytics Metrics
 *
 * Patterns Implemented:
 * - Event-Driven Analytics
 * - Eventual Consistency
 *
 * This consumer listens for successful inventory
 * reservations and updates completed order metrics.
 *
 * Flow:
 *
 * Inventory Service
 *      ↓
 * inventory-reserved (Kafka Topic)
 *      ↓
 * Analytics Service
 *      ↓
 * Increment COMPLETED_ORDERS
 */
@Component
@RequiredArgsConstructor
public class InventoryReservedConsumer {

    private final AnalyticsService analyticsService;

    /**
     * Consumes InventoryReservedEvent and increments
     * the completed orders metric.
     */
    @KafkaListener(
            topics = KafkaTopics.INVENTORY_RESERVED,
            groupId = "analytics-service-group",
            containerFactory =
                    "inventoryReservedKafkaListenerContainerFactory"
    )
    public void consume(
            InventoryReservedEvent event) {

        /*
         * Update analytics metrics when
         * an order is completed successfully.
         */
        analyticsService.incrementCompletedOrders();
    }
}