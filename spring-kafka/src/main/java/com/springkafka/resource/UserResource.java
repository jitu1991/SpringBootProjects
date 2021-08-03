package com.springkafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springkafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {

	@Autowired
	KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "KafkaExample";
	
	@GetMapping("/publish/{name}")
	public String getMessage(@PathVariable("name") final String name) {
		//kafkaTemplate.send(TOPIC, message);
		
		kafkaTemplate.send(TOPIC, new User(name, 344.5));
		return "Published Successfully";
	}
}
