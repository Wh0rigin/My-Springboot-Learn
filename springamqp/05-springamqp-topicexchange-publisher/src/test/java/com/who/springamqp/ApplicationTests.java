package com.who.springamqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	private String exchangeName = "simple.topic";
	private String sendMsg = "hello,everyone";

	@Test
	void contextLoads() {
		rabbitTemplate.convertAndSend(exchangeName,"usa.bad",sendMsg+"【usa】");
		rabbitTemplate.convertAndSend(exchangeName,"china.good",sendMsg+"【china】");
	}

}
