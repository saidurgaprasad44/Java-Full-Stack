package com.example.analyticsservice.dto;

public record MetricsResponse(

        Long totalOrders,

        Long completedOrders,

        Long cancelledOrders
) {
}