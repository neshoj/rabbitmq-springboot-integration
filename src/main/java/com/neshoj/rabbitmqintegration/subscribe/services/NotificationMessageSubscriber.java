package com.neshoj.rabbitmqintegration.subscribe.services;

import com.neshoj.rabbitmqintegration.publish.NotificationData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationMessageSubscriber {

    @RabbitListener(queues = {"${notifications.queue}"})
    public void receiveMessageFromTopic1(NotificationData data) {
    System.out.println("Received data from RabbitMq = " + data.toString());
    }
}
