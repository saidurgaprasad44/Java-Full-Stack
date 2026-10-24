package com.example.analyticsservice.service;

import com.example.analyticsservice.dto.MetricsResponse;

public interface AnalyticsService {

    void incrementTotalOrders();

    void incrementCompletedOrders();

    void incrementCancelledOrders();

    MetricsResponse getMetrics();
}