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

	@RabbitListener(queuesToDeclare = {@Queue("fanout.queue1"),@Queue("fanout.queue2")})
	@Test
	void testSendMsgtoExchange() throws InterruptedException {
		String exChangeName = "simple.fanout";
		String message = "hello,everyone";
		rabbitTemplate.convertAndSend(exChangeName,"",message);
	}
}
