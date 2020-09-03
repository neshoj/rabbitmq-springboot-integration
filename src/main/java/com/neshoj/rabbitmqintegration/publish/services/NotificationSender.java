package com.neshoj.rabbitmqintegration.publish.services;

import com.neshoj.rabbitmqintegration.publish.NotificationData;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationSender {
    private final AmqpTemplate rabbitTemplate;

    @Value(value = "${notification.routingkey}")
    String routingKeyName;

    @Value("${rabbimqintergration.exchange}")
    String topicExchangeName;


    public void sendNotification(NotificationData request) {
        rabbitTemplate.convertAndSend(topicExchangeName, routingKeyName, request);
        System.err.println("Notification message sent: " + request.getMessageBody());
    }
}
