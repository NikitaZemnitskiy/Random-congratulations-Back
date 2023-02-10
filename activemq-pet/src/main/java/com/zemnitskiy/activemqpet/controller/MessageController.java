package com.zemnitskiy.activemqpet.controller;

import com.zemnitskiy.activemqpet.dto.Message;
import com.zemnitskiy.activemqpet.jms.MessageConsumer;
import com.zemnitskiy.activemqpet.jms.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
  @Autowired
  MessageProducer messageProducer;

  @Autowired
  MessageConsumer messageConsumer;

  @Value("${activemq.destination}")
  private String destination;

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/sendMessage")
  public String sendMessage(@RequestBody Message message) {
    messageProducer.sendTo(destination, message);
    return "success";
  }

  @GetMapping("/getMessage")
  public Message getMessage() {
    return messageConsumer.receiveMessage(destination);
  }
}
