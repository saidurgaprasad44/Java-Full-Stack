package com.example.orderservice.service.impl;

import com.example.contracts.event.OrderCreatedEvent;
import com.example.orderservice.dto.CreateOrderRequest;
import com.example.orderservice.dto.CreateOrderResponse;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OutboxEvent;
import com.example.orderservice.enums.OrderStatus;
import com.example.orderservice.kafka.OrderEventProducer;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.repository.OutboxEventRepository;
import com.example.orderservice.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * ===================================
 * Handles order lifecycle operations
 * ===================================
 *
 * Responsibilities:
 * - Create Orders
 * - Complete Orders
 * - Cancel Orders
 *
 * Patterns Implemented:
 * - Choreography-Based Saga
 * - Transactional Outbox Pattern
 *
 * This service initiates the Saga workflow by
 * creating an order and storing OrderCreatedEvent
 * in the Outbox table.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventProducer orderEventProducer;

    private final OutboxEventRepository outboxEventRepository;
    private final ObjectMapper objectMapper;

    /**
     * Creates a new order and stores OrderCreatedEvent
     * in the Outbox table within the same transaction.
     *
     * The Outbox Publisher later publishes the event
     * to Kafka, ensuring database and event consistency.
     */
    @Transactional
    @Override
    public CreateOrderResponse createOrder(
            CreateOrderRequest request) {

        Order order = Order.builder()
                .customerId(request.customerId())
                .productId(request.productId())
                .quantity(request.quantity())
                .amount(request.amount())
                .status(OrderStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .build();

        order = orderRepository.save(order);

        OrderCreatedEvent orderCreatedEvent =
                new OrderCreatedEvent(
                        order.getId(),
                        order.getCustomerId(),
                        order.getProductId(),
                        order.getQuantity(),
                        order.getAmount(),
                        order.getStatus().name());

        try {

            /*
             * Store event in Outbox table instead of
             * publishing directly to Kafka.
             *
             * This prevents database and Kafka
             * inconsistency if publishing fails.
             */
            OutboxEvent outboxEvent =
                    OutboxEvent.builder()
                            .id(UUID.randomUUID())
                            .aggregateId(order.getId())
                            .eventType("OrderCreatedEvent")
                            .payload(
                                    objectMapper.writeValueAsString(
                                            orderCreatedEvent))
                            .published(false)
                            .createdAt(LocalDateTime.now())
                            .build();

            log.info(
                    "Outbox event payload={}",
                    outboxEvent);

            outboxEventRepository.save(
                    outboxEvent);

            log.info(
                    "Outbox event saved successfully");

        } catch (JsonProcessingException ex) {

            throw new RuntimeException(
                    "Failed to serialize outbox event",
                    ex);
        }

        return new CreateOrderResponse(
                order.getId(),
                order.getStatus().name());
    }

    /**
     * Marks an order as COMPLETED after inventory
     * has been successfully reserved.
     *
     * Triggered by InventoryReservedEvent.
     */
    @Transactional
    @Override
    public void completeOrder(UUID orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found. orderId="
                                        + orderId));

        order.setStatus(
                OrderStatus.COMPLETED);

        orderRepository.save(order);

        log.info(
                "Order completed. orderId={}",
                orderId);
    }

    /**
     * Marks an order as CANCELLED during Saga
     * compensation after a payment refund.
     *
     * Triggered by PaymentRefundedEvent.
     */
    @Transactional
    @Override
    public void cancelOrder(UUID orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Order not found. orderId="
                                        + orderId));

        order.setStatus(
                OrderStatus.CANCELLED);

        orderRepository.save(order);

        log.info(
                "Order cancelled. orderId={}",
                orderId);
    }
}