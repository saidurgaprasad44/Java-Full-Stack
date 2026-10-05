package com.example.paymentservice.producer;

import com.example.contracts.constants.KafkaTopics;
import com.example.contracts.event.PaymentRefundedEvent;
import com.example.contracts.event.PaymentSucceededEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publishPaymentSucceededEvent(
            PaymentSucceededEvent event) {

        kafkaTemplate.send(
                        KafkaTopics.PAYMENT_SUCCEEDED,
                        event.orderId().toString(),
                        event)
                .whenComplete((result, ex) -> {

                    if (ex == null) {

                        log.info(
                                "Published PaymentSucceededEvent. orderId={}, partition={}, offset={}",
                                event.orderId(),
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());

                    } else {

                        log.error(
                                "Failed to publish PaymentSucceededEvent. orderId={}",
                                event.orderId(),
                                ex);
                    }
                });
    }

    public void publishPaymentRefundedEvent(
            PaymentRefundedEvent event) {

        kafkaTemplate.send(
                        KafkaTopics.PAYMENT_REFUNDED,
                        event.orderId().toString(),
                        event)
                .whenComplete((result, ex) -> {

                    if (ex == null) {

                        log.info(
                                "Published PaymentRefundedEvent. orderId={}",
                                event.orderId());

                    } else {

                        log.error(
                                "Failed to publish PaymentRefundedEvent. orderId={}",
                                event.orderId(),
                                ex);
                    }
                });
    }
}