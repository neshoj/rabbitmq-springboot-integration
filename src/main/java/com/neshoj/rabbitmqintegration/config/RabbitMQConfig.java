package com.neshoj.rabbitmqintegration.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value(value = "${notifications.queue}")
    String notificationsQueueName;

    @Value(value = "${notification.routingkey}")
    String notificationsRoutingKeyName;

    @Value("${rabbimqintergration.exchange}")
    String topicExchangeName;

    @Bean
    public Declarables topicBindings() {
        Queue notificationsQueue = new Queue(notificationsQueueName, true);
        TopicExchange topicExchange = new TopicExchange(topicExchangeName);
        return new Declarables(
                notificationsQueue,
                topicExchange,
                BindingBuilder.bind(notificationsQueue).to(topicExchange).with(notificationsRoutingKeyName)
        );
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
