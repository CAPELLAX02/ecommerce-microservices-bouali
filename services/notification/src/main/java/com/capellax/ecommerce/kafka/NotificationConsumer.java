package com.capellax.ecommerce.kafka;

import com.capellax.ecommerce.enums.NotificationType;
import com.capellax.ecommerce.kafka.order.OrderConfirmation;
import com.capellax.ecommerce.kafka.payment.PaymentConfirmation;
import com.capellax.ecommerce.model.Notification;
import com.capellax.ecommerce.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository notificationRepository;
    // private final EmailService emailService

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(
            PaymentConfirmation paymentConfirmation
    ) {
        log.info("Consuming the message from 'payment-topic' Topic:: {}", paymentConfirmation);
        notificationRepository.save(
                Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );
        // TODO: Send email
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderSuccessNotification(
            OrderConfirmation orderConfirmation
    ) {
        log.info("Consuming the message from 'order-topic' Topic:: {}", orderConfirmation);
        notificationRepository.save(
                Notification.builder()
                        .type(NotificationType.ORDER_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );
        // TODO: Send email
    }

}
