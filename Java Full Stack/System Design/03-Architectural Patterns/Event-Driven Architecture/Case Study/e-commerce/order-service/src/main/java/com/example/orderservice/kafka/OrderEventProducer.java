package com.example.orderservice.kafka;

import com.example.contracts.constants.KafkaTopics;
import com.example.contracts.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderEventProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void publishOrderCreatedEvent(OrderCreatedEvent event) {

        kafkaTemplate.send(
                        KafkaTopics.ORDER_CREATED,
                        event.orderId().toString(),
                        event)
                .whenComplete((result, ex) -> {

                    if (ex == null) {

                        log.info(
                                "Published OrderCreatedEvent. orderId={}, partition={}, offset={}",
                                event.orderId(),
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());

                    } else {

                        log.error(
                                "Failed to publish OrderCreatedEvent. orderId={}",
                                event.orderId(),
                                ex);
                    }
                });
    }
}