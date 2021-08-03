package com.springkafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springkafka.model.User;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "KafkaExample", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consume message: " + message);
	}
	
	@KafkaListener(topics = "KafkaExampleJson", groupId = "group_json", containerFactory = "userKafkaListenerContainerFactory")
	public void consume(User user) {
		System.out.println("Consume message: " + user);
	}
}
