package com.who.springamqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@RabbitListener(queuesToDeclare = {@Queue("simple.queue")})
	@Test
	void contextLoads() throws InterruptedException {
		String queueName = "simple.queue";
		String message = "hello,world!";
		for (int i = 0; i < 100; i++) {
			rabbitTemplate.convertAndSend(queueName, message + "[" + i + "]");
			Thread.sleep(1000);
		}
	}
}
