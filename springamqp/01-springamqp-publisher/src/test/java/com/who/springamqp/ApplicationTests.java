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

	//自动创建队列
	@RabbitListener(queuesToDeclare = {@Queue("simple.queue")})
	@Test
	void contextLoads() {
		String queueName = "simple.queue";
		String message = "hello , spring amqp!";
		rabbitTemplate.convertAndSend(queueName,message);
	}

}
