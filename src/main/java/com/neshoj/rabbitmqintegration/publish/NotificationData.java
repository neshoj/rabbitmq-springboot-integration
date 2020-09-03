package com.neshoj.rabbitmqintegration.publish;

import lombok.Data;

@Data
public class NotificationData {
    private String recipient;
    private String messageBody;

    @Override
    public String toString() {
        return "NotificationData{" +
                "recipient='" + recipient + '\'' +
                ", messageBody='" + messageBody + '\'' +
                '}';
    }
}
