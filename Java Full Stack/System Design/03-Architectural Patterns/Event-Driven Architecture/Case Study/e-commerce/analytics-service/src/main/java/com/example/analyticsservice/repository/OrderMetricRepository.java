package com.example.analyticsservice.repository;

import com.example.analyticsservice.entity.OrderMetric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMetricRepository
        extends JpaRepository<OrderMetric, String> {
}