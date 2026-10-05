package com.example.inventoryservice.service.impl;

import com.example.contracts.event.InventoryFailedEvent;
import com.example.contracts.event.InventoryReservedEvent;
import com.example.contracts.event.PaymentSucceededEvent;
import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.entity.ProcessedEvent;
import com.example.inventoryservice.producer.InventoryEventProducer;
import com.example.inventoryservice.repository.InventoryRepository;
import com.example.inventoryservice.repository.ProcessedEventRepository;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * ==========================================
 * Handles Inventory Reservation
 * ==========================================
 *
 * Responsibilities:
 * - Reserve Inventory
 * - Publish Inventory Reserved Events
 * - Publish Inventory Failed Events
 * - Prevent Duplicate Event Processing
 *
 * Patterns Implemented:
 * - Choreography-Based Saga
 * - Idempotent Consumer Pattern
 * - Eventual Consistency
 *
 * This service participates in the Saga workflow
 * after payment has been completed successfully.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl
        implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final InventoryEventProducer inventoryEventProducer;

    private final ProcessedEventRepository
            processedEventRepository;

    /**
     * Attempts to reserve inventory for a paid order.
     *
     * Success:
     * - Updates inventory
     * - Records processed event
     * - Publishes InventoryReservedEvent
     *
     * Failure:
     * - Publishes InventoryFailedEvent
     */
    @Transactional
    @Override
    public void reserveInventory(
            PaymentSucceededEvent paymentSucceededEvent) {

        /*
         * Used for testing Retry & DLT handling.
         *
         * Flow:
         * payment-succeeded (Kafka Topic)
         *      ↓
         * payment-succeeded-retry (Kafka Topic)
         *      ↓
         * payment-succeeded-dlt (Kafka Topic)
         */
        if (paymentSucceededEvent.productId() == 9999L) {

            throw new RuntimeException(
                    "Simulated inventory failure");
        }

        /*
         * Idempotent Consumer Pattern.
         *
         * Ignore duplicate Kafka events that
         * have already been processed.
         */
        if (processedEventRepository.existsById(
                paymentSucceededEvent.eventId())) {

            log.info(
                    "Duplicate event ignored. eventId={}",
                    paymentSucceededEvent.eventId());

            return;
        }

        log.info(
                "Reserving inventory. orderId={}, productId={}, quantity={}",
                paymentSucceededEvent.orderId(),
                paymentSucceededEvent.productId(),
                paymentSucceededEvent.quantity());

        /*
         * Used for testing retry processing.
         */
        if (paymentSucceededEvent.productId()
                .equals(1003L)) {

            throw new RuntimeException(
                    "Simulated technical failure");
        }

        Inventory inventory =
                inventoryRepository.findById(
                                paymentSucceededEvent.productId())
                        .orElse(null);

        /*
         * Saga compensation path.
         *
         * Product not found.
         * Publish InventoryFailedEvent so that
         * Payment Service can initiate refund.
         */
        if (inventory == null) {

            InventoryFailedEvent inventoryFailedEvent =
                    new InventoryFailedEvent(
                            paymentSucceededEvent.orderId(),
                            paymentSucceededEvent.productId(),
                            paymentSucceededEvent.quantity(),
                            "Product not found");

            inventoryEventProducer.publishInventoryFailedEvent(
                    inventoryFailedEvent);

            log.warn(
                    "Inventory reservation failed. Product not found. productId={}",
                    paymentSucceededEvent.productId());

            return;
        }

        /*
         * Saga compensation path.
         *
         * Insufficient inventory available.
         * Publish InventoryFailedEvent.
         */
        if (inventory.getAvailableQuantity()
                < paymentSucceededEvent.quantity()) {

            InventoryFailedEvent inventoryFailedEvent =
                    new InventoryFailedEvent(
                            paymentSucceededEvent.orderId(),
                            paymentSucceededEvent.productId(),
                            paymentSucceededEvent.quantity(),
                            "Insufficient inventory");

            inventoryEventProducer.publishInventoryFailedEvent(
                    inventoryFailedEvent);

            log.warn(
                    "Inventory reservation failed. orderId={}, availableQuantity={}, requestedQuantity={}",
                    paymentSucceededEvent.orderId(),
                    inventory.getAvailableQuantity(),
                    paymentSucceededEvent.quantity());

            return;
        }

        /*
         * Reserve inventory by reducing
         * available quantity.
         */
        inventory.setAvailableQuantity(
                inventory.getAvailableQuantity()
                        - paymentSucceededEvent.quantity());

        inventory.setUpdatedAt(LocalDateTime.now());

        inventoryRepository.save(inventory);

        /*
         * Record processed event to support
         * Idempotent Consumer Pattern.
         */
        processedEventRepository.save(
                ProcessedEvent.builder()
                        .eventId(
                                paymentSucceededEvent.eventId())
                        .processedAt(
                                LocalDateTime.now())
                        .build());

        /*
         * Happy path of the Saga workflow.
         *
         * Inventory reserved successfully.
         * Notify downstream services.
         */
        InventoryReservedEvent inventoryReservedEvent =
                new InventoryReservedEvent(
                        paymentSucceededEvent.orderId(),
                        paymentSucceededEvent.productId(),
                        paymentSucceededEvent.quantity());

        inventoryEventProducer.publishInventoryReservedEvent(
                inventoryReservedEvent);

        log.info(
                "Inventory reserved successfully. orderId={}, remainingQuantity={}",
                paymentSucceededEvent.orderId(),
                inventory.getAvailableQuantity());
    }
}