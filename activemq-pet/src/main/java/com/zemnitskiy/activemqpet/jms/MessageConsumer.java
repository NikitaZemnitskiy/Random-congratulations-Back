package com.zemnitskiy.activemqpet.jms;

import com.zemnitskiy.activemqpet.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {

  @Autowired
  private JmsTemplate jmsTemplate;

  public Message receiveMessage(String destination) {
    Message message = (Message) jmsTemplate.receiveAndConvert(destination);
    log.info("Consumer> " + message);
    return message;
  }

}