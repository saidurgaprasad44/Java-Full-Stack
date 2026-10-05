package com.example.inventoryservice.consumer;

import com.example.contracts.constants.KafkaTopics;
import com.example.contracts.event.PaymentSucceededEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentSucceededDltConsumer {

    @KafkaListener(
            topics = KafkaTopics.PAYMENT_SUCCEEDED_DLT,
            groupId = "inventory-service-dlt-group",
            containerFactory =
                    "kafkaListenerContainerFactory"
    )
    public void consume(
            PaymentSucceededEvent event) {

        log.error(
                """
                DLT EVENT RECEIVED

                eventId={}
                orderId={}
                productId={}
                retryCount={}
                """,
                event.eventId(),
                event.orderId(),
                event.productId(),
                event.retryCount());
    }
}