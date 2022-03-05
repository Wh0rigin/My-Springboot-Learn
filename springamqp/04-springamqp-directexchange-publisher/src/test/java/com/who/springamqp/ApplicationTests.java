package com.who.springamqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	private String exChangeName = "simple.direct";
	private String message = "hello,everyone";

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	void testSendMsgtoExchange() throws InterruptedException {
		rabbitTemplate.convertAndSend(exChangeName,"A",message+"【A】");
		rabbitTemplate.convertAndSend(exChangeName,"B",message+"【B】");
		rabbitTemplate.convertAndSend(exChangeName,"C",message+"【C】");
	}

	@Test
	void testSendAGroup(){
		rabbitTemplate.convertAndSend(exChangeName,"A",message+"【A】");
	}

	@Test
	void testSendBGroup(){
		rabbitTemplate.convertAndSend(exChangeName,"B",message+"【B】");
	}

	@Test
	void testSendCGroup(){
		rabbitTemplate.convertAndSend(exChangeName,"C",message+"【C】");
	}
}
