package com.qinyadan.brick;


import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ProducerTest {
	
	public static void main(String[] args) throws Exception, ExecutionException {
		Properties props = new Properties();

		props.put("bootstrap.servers", "localhost:9092");
		props.put("request.required.acks", "1");
		props.put("retries", 4);
		// props.put("batch.size", 16384);
		// props.put("linger.ms", 1);
		// props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer(props);
		int maxMessages = 1000;

		int count = 0;
		while(count < maxMessages) {
		producer.send(new ProducerRecord<String, String>("test", "message --- #"+count++)).get();
		System.out.println("Message send.."+count);
		}
		producer.close();
	}
}
