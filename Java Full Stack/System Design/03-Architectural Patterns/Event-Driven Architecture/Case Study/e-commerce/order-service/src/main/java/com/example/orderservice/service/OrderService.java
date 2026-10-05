package com.example.orderservice.service;

import com.example.orderservice.dto.CreateOrderRequest;
import com.example.orderservice.dto.CreateOrderResponse;

import java.util.UUID;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest request);

    void completeOrder(UUID orderId);

    void cancelOrder(UUID orderId);
}