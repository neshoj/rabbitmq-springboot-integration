package com.neshoj.rabbitmqintegration.publish.controller;

import com.neshoj.rabbitmqintegration.publish.NotificationData;
import com.neshoj.rabbitmqintegration.publish.services.NotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostMessageController {
  private final NotificationSender notificationSender;

  @RequestMapping(path = "/notification")
  public ResponseEntity postMessage(@RequestBody NotificationData request) {
    notificationSender.sendNotification(request);
    System.out.println("Message already sent to MQ");
    return ResponseEntity.status(200).build();
  }
}
