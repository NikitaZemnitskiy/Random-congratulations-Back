package com.zemnitskiy.activemqpet.jms;

import com.zemnitskiy.activemqpet.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageProducer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendTo(String destination, Message message) {
		jmsTemplate.convertAndSend(destination, message);
		log.info("Producer> Message Sent" + message);
	}
}