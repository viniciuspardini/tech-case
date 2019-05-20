package com.caseitau.vinicius.pardini.kafkaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caseitau.vinicius.pardini.kafkaservice.service.Consumer;
import com.caseitau.vinicius.pardini.kafkaservice.service.Producer;

@RestController
@RequestMapping(value = "/pardini")
public class KafkaController {
	
	private final Producer producer;
	private final Consumer consumer;
 
	@Autowired
	public KafkaController(Producer producer, Consumer consumer) {
		this.producer = producer;
		this.consumer = consumer;
	}
	
	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message){
		this.producer.sendMessage(message);
	}
}
